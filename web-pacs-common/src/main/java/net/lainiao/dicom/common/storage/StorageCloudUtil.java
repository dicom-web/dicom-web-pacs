package net.lainiao.dicom.common.storage;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;


import java.io.File;

public class StorageCloudUtil implements StorageUtil {
    private AmazonS3 s3Client = null;

    private OSSClient ossClient = null;
    private String type;
    private String endPoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private StorageUtil storageUtil;

    public StorageCloudUtil(String type, String endPoint, String accessKeyId, String accessKeySecret, String bucketName) {
        this.type = type;
        this.endPoint = endPoint;
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.bucketName = bucketName;
    }

    @Override
    public void open() throws Exception {
        if (type.equalsIgnoreCase("OSS")) {
            this.storageUtil = new OssOpration();
        } else if (type.equalsIgnoreCase("NAS")) {
            this.storageUtil = new NasOpration();
        } else if (type.equalsIgnoreCase("MINIO")) {
            this.storageUtil = new NasOpration();
        }
        storageUtil.open();
    }


    @Override
    public void putObject(String objectName, File file) throws Exception {
        storageUtil.putObject(objectName, file);
    }


    @Override
    public void removeObject(String objectName) {
        storageUtil.removeObject(objectName);
    }


    @Override
    public void close() {
        try {
            storageUtil.close();
        } catch (Exception e) {

        }
    }

    @Override
    public void getObject(String objectName, File targetFile) throws Exception {
        storageUtil.getObject(objectName, targetFile);
    }

    @Override
    public boolean doesObjectExist(String objectName) {
        return storageUtil.doesObjectExist(objectName);
    }

    class OssOpration implements StorageUtil {
        private OSSClient ossClient;

        @Override
        public void open() throws Exception {
            ossClient = new OSSClient(endPoint, accessKeyId, accessKeySecret);
        }

        @Override
        public void putObject(String objectName, File file) throws Exception {
            ossClient.putObject(bucketName, objectName, file);
        }

        @Override
        public void removeObject(String objectName) {
            ossClient.deleteObject(bucketName, objectName);
        }

        @Override
        public void close() throws Exception {
            ossClient.shutdown();
        }

        @Override
        public void getObject(String objectName, File targetFile) throws Exception {
            ossClient.getObject(new GetObjectRequest(bucketName, objectName), targetFile);
        }

        @Override
        public boolean doesObjectExist(String objectName) {
            return ossClient.doesObjectExist(bucketName, objectName);
        }
    }

    class NasOpration implements StorageUtil {
        private AmazonS3 ossClient;

        @Override
        public void open() throws Exception {
            BasicAWSCredentials credentials = new BasicAWSCredentials(accessKeyId, accessKeySecret);
            ClientConfiguration clientConfig = new ClientConfiguration();
            clientConfig.setSignerOverride("S3SignerType");//凭证验证方式
            clientConfig.setProtocol(Protocol.HTTP);//访问协议
            s3Client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withClientConfiguration(clientConfig).withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endPoint, "localStore")).withPathStyleAccessEnabled(true).build();
        }

        @Override
        public void putObject(String objectName, File file) throws Exception {
            s3Client.putObject(bucketName, objectName, file);
        }

        @Override
        public void removeObject(String objectName) {
            s3Client.deleteObject(bucketName, objectName);
        }

        @Override
        public void close() throws Exception {
            s3Client.shutdown();
        }

        @Override
        public void getObject(String objectName, File targetFile) throws Exception {
            com.amazonaws.services.s3.model.GetObjectRequest objectRequest = new com.amazonaws.services.s3.model.GetObjectRequest(bucketName, objectName);
            s3Client.getObject(objectRequest, targetFile);
        }

        @Override
        public boolean doesObjectExist(String objectName) {
            return s3Client.doesObjectExist(bucketName, objectName);
        }
    }
}
