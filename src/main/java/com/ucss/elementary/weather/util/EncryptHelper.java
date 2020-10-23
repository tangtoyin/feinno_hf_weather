package com.ucss.elementary.weather.util;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*加解密*/
public final class EncryptHelper {

    //region 3DesECB模式
    //获取3des加密key
    public static byte[] build3DESKey(String encryptionKey) throws Exception {
        byte[] key = encryptionKey.getBytes("UTF-8");

        byte[] temp = new byte[24];
        if (key.length > temp.length) {
            System.arraycopy(key, 0, temp, 0, temp.length);
        } else {
            System.arraycopy(key, 0, temp, 0, key.length);
        }
        return temp;
    }

    //加密
    public static String encode3DES(String message, String keyString) {
        //DES加密字符串
        String result = "";
        //去掉换行符后的加密字符串
        String newResult = "";
        try {
            //获得密钥
            SecretKey secretKey = new SecretKeySpec(build3DESKey(keyString), "DESede");
            /*获得一个私鈅加密类Cipher，DESede是算法，ECB是加密模式，PKCS5Padding是填充方式*/
            Cipher cipher = Cipher.getInstance("DESede");
            //设置工作模式为加密模式，给出密钥
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            //正式执行加密操作
            byte[] resultBytes = cipher.doFinal(message.getBytes("UTF-8"));
            BASE64Encoder enc = new BASE64Encoder();
            //进行BASE64编码
            result = enc.encode(resultBytes);
            //去掉加密串中的换行符
            result = result.replaceAll("[\\r\\n]", "");
        } catch (Exception e) {
            return e.getMessage();
        }
        return result;
    }

    //解密
    public static String decode3DesECB(String message, String keyString) throws Exception {
        String result = "";
        try {
            //获得密钥
            SecretKey secretKey = new SecretKeySpec(build3DESKey(keyString), "DESede");
            BASE64Decoder dec = new BASE64Decoder();
            //进行BASE64编码
            byte[] messageBytes = dec.decodeBuffer(message);
            Cipher cipher = Cipher.getInstance("DESede");
            //设置工作模式为解密模式，给出密钥
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            //正式执行解密操作
            byte[] resultBytes = cipher.doFinal(messageBytes);
            result = new String(resultBytes, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //endregion

    public static String getSHA256StrJava(String str) {
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }


    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }


    public static String hmacsha1String(String str, String key) {
        try {
            byte[] bytesStr = str.getBytes("UTF-8");
            byte[] bytesKey = key.getBytes("UTF-8");
            return hmacsha1(bytesStr, bytesKey);
        } catch (Exception ex) {
            return "";
        }

    }

    public static String hmacsha1(byte[] data, byte[] key) {
        try {
            SecretKeySpec signingKey = new SecretKeySpec(key, "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            return byte2hex(mac.doFinal(data));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }
//1B6D5DE5284239FA3568BF4F9940F2E4A3A5CDD1

    //二行制转字符串
    public static String byte2hex(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b != null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1) {
                hs.append('0');
            }
            hs.append(stmp);
        }
        return hs.toString().toUpperCase();
    }


    public static void main(String[] args){
        String str="/tnwn/UserInfo/detail?PARAM={phonenum:13429852091,platformcode:110}&appcode=appcode_0111&rnd=86299524&ts=1569397196585";
        String key="MGUiL7e3";
        System.out.println(EncryptHelper.hmacsha1String(str,key));
    }

}
