package net.lainiao.dicom.scp.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class HttpUtils {

	// private static Logger logger = Logger.getLogger(HttpRequestUtil.class);
	private static Logger log = LoggerFactory.getLogger(HttpUtils.class);

	public static final String GET_METHOD = "GET";

	public static final String POST_METHOD = "POST";

	public static final String DEFAULT_CHARSET = "utf-8";
	/**
     * 向指定URL发送GET方法的请求
     *
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
	 public static String sendGet(String url, String param) {
	       return sendGet(url,param,null);
	    }
    public static String sendGet(String url, String param, String token) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setRequestMethod("GET"); // 设置请求方式
            connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式
            connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式
            if(token!=null){
            	connection.setRequestProperty("token", token); // 设置token
          }
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
       return sendPost(url,param,null);
    }

	public static String sendPost(String url, String param, String token) {
		 return sendPost(url,param,null,null,0);
	}
	public static String sendPost(String url, String param,String ct, String token,int f) {
		 PrintWriter out = null;
	        BufferedReader in = null;
	        String result = "";
	        try {
	        	String urlNameString = url;
	        	if(f==1){
	        		urlNameString = urlNameString + "?" + "access_token="+token;
	        	}
	            URL realUrl = new URL(urlNameString);
	            // 打开和URL之间的连接
	            HttpURLConnection  conn = (HttpURLConnection) realUrl.openConnection();
	            // 设置通用的请求属性
	            conn.setRequestProperty("connection", "Keep-Alive");
	            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	            conn.setRequestMethod("POST"); // 设置请求方式
	            conn.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式

	            if(ct!=null){
	            	  conn.setRequestProperty("Content-Type", ct); // 设置Content-Type
	            }else{
	            	 conn.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式
	            }
	            if(token!=null){
	            	  conn.setRequestProperty("token", token); // 设置token
	            }
	            // 发送POST请求必须设置如下两行
	            conn.setDoOutput(true);
	            conn.setDoInput(true);
	            // 获取URLConnection对象对应的输出流
	            out = new PrintWriter(conn.getOutputStream());
	            // 发送请求参数
	            out.print(param);
	            // flush输出流的缓冲
	            out.flush();
	            if(ct==null){
		            // 定义BufferedReader输入流来读取URL的响应
		            in = new BufferedReader(
		                    new InputStreamReader(conn.getInputStream(),"UTF-8"));
		            String line;
		            while ((line = in.readLine()) != null) {
		                result += line;
		            }
	            }
	        } catch (Exception e) {
	            System.out.println("发送 POST 请求出现异常！"+e);
	            e.printStackTrace();
	        }
	        //使用finally块来关闭输出流、输入流
	        finally{
	            try{
	                if(out!=null){
	                    out.close();
	                }
	                if(in!=null){
	                    in.close();
	                }
	            }
	            catch(IOException ex){
	                ex.printStackTrace();
	            }
	        }
	        return result;
	}


	public static String requestCloudInterface(String serviceUrl, String data) throws IOException {
        log.info("HttpTest.requestCloudInterface 请求url:" + serviceUrl);
        log.info("HttpTest.requestCloudInterface 请求参数:" + data);
        URL url = new URL(serviceUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        connection.setInstanceFollowRedirects(false);
        connection.setConnectTimeout(2000);
        OutputStream os = connection.getOutputStream();
        os.write(data.getBytes("UTF-8"));
        os.flush();
        InputStream i = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(i, "UTF-8"));
        StringBuffer sb = new StringBuffer();
        String tmp = reader.readLine();
        while (tmp != null) {
            sb.append(tmp);
            tmp = reader.readLine();
        }
        connection.disconnect();
        log.info("requestCloudInterface 响应参数:" + sb.toString());
        return sb.toString();
    }

}
