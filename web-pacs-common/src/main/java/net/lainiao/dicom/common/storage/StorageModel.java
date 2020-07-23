package net.lainiao.dicom.common.storage;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class StorageModel {
    private Logger logger = LoggerFactory.getLogger(StorageModel.class);

    @Value("${storage.domain:}")
    public String domain = null;

    @Value("${storage.cloud.endpoint:}")
    public String cloudEndPoint = null;

    @Value("${storage.cloud.accessKeyId:}")
    public String cloudAccessKeyId = null;

    @Value("${storage.cloud.accessKeySecret:}")
    public String cloudAccessKeySecret = null;

    @Value("${storage.cloud.bucketName:}")
    public String cloudBucketName = null;

    @Value("${storage.cloud.type:}")
    public String cloudType = null;

    @Value("${storage.cloud.sts.arn:}")
    public String cloudStsArn = null;

    @Value("${storage.cloud.sts.policy-path:}")
    public String cloudStsPolicyPath = null;

    @Value("${storage.cloud.region:}")
    public String cloudRegion = null;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getCloudEndPoint() {
        return cloudEndPoint;
    }

    public void setCloudEndPoint(String cloudEndPoint) {
        this.cloudEndPoint = cloudEndPoint;
    }

    public String getCloudAccessKeyId() {
        return cloudAccessKeyId;
    }

    public void setCloudAccessKeyId(String cloudAccessKeyId) {
        this.cloudAccessKeyId = cloudAccessKeyId;
    }

    public String getCloudAccessKeySecret() {
        return cloudAccessKeySecret;
    }

    public void setCloudAccessKeySecret(String cloudAccessKeySecret) {
        this.cloudAccessKeySecret = cloudAccessKeySecret;
    }

    public String getCloudBucketName() {
        return cloudBucketName;
    }

    public void setCloudBucketName(String cloudBucketName) {
        this.cloudBucketName = cloudBucketName;
    }

    public String getCloudType() {
        return cloudType;
    }

    public void setCloudType(String cloudType) {
        this.cloudType = cloudType;
    }

    public String getCloudStsArn() {
        return cloudStsArn;
    }

    public void setCloudStsArn(String cloudStsArn) {
        this.cloudStsArn = cloudStsArn;
    }

    public String getCloudStsPolicyPath() {
        return cloudStsPolicyPath;
    }

    public void setCloudStsPolicyPath(String cloudStsPolicyPath) {
        this.cloudStsPolicyPath = cloudStsPolicyPath;
    }

    public String getCloudRegion() {
        return cloudRegion;
    }

    public void setCloudRegion(String cloudRegion) {
        this.cloudRegion = cloudRegion;
    }


}
