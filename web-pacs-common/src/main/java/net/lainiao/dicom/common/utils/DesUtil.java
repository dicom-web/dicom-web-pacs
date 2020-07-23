package net.lainiao.dicom.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

/**
 * Des加解密工具类
 *
 * @author Lee
 * @version 2019/9/9
 */
public class DesUtil {

    private static Logger log = LoggerFactory.getLogger(DesUtil.class);

    private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static AlgorithmParameterSpec iv = null;// 加密算法的参数接口，IvParameterSpec是它的一个实现
    private static SecretKey key = null;

    private static void init(String desKey, String desIv) throws Exception {
        byte[] DESkey = desKey.getBytes();
        byte[] DESIV = desIv.getBytes();
        DESKeySpec keySpec = new DESKeySpec(DESkey);// 设置密钥参数
        iv = new IvParameterSpec(DESIV);// 设置向量
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");// 获得密钥工厂
        key = keyFactory.generateSecret(keySpec);// 得到密钥对象
    }

    /**
     * 加密
     * @param data 待加密的数据
     * @return 加密后的数据
     * @throws Exception
     */
    public static String encode(String data,String desKey, String desIv) {
        try {
            init(desKey,desIv);
            Cipher enCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");// 得到加密对象Cipher
            enCipher.init(Cipher.ENCRYPT_MODE, key, iv);// 设置工作模式为加密模式，给出密钥和向量
            byte[] pasByte = enCipher.doFinal(data.getBytes("utf-8"));
            return byte2hex(pasByte);
        } catch (Exception e) {
            log.error("encode fail:"+e.toString());
            return null;
        }
    }

    public static byte[] hex2byte(String strhex) {
        if (strhex == null) {
            return null;
        }
        int l = strhex.length();
        if (l % 2 == 1) {
            return null;
        }
        byte[] b = new byte[l / 2];
        for (int i = 0; i != l / 2; i++) {
            b[i] = (byte) Integer.parseInt(strhex.substring(i * 2, i * 2 + 2), 16);
        }
        return b;
    }

    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }
        return hs.toUpperCase();
    }



    /**
     * 解密
     * @param data  解密前的数据
     * @return 解密后的数据
     * @throws Exception
     */
    public static String decode(String data,String desKey, String desIv) {
        try {
            init(desKey,desIv);
            Cipher deCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            deCipher.init(Cipher.DECRYPT_MODE, key, iv);
            byte[] pasByte = deCipher.doFinal(Base64.getDecoder().decode(data));
            return new String(pasByte, "UTF-8");
        } catch (Exception e) {
            log.error("decode fail:"+e.toString());
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        String desKey = "d775a445dcb4413abd";
        String desIv = "11111111";
        String data = "1234567891112";
        System.out.println("加密:" + encode(data,desKey,desIv));

        String data1 = encode(data,desKey,desIv);

        System.out.println("解密:" + decode(data1,desKey,"12345679"));
    }

}
