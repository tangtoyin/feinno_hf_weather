package com.ucss.elementary.weather.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.codec.digest.DigestUtils;

public class Sign {
    private static final String CHARSET = "UTF-8";
    /**
     * 生成签名
     *
     * @param key 签名秘钥
     * @param parameters 参数
     * @return
     */
    public static String sign(String key, Map<String, String> parameters) {
        Map<String, String> filteredParams = filterParameters(parameters);
        String link = linkParameters(filteredParams);
        String mysign = MD5.sign(link, key, CHARSET);
        return mysign;
    }
    /**
     * sign不参与生成签名
     *
     * @param parameters
     * @return
     */
    private static Map<String, String> filterParameters(Map<String, String>
                                                                parameters) {
        Map<String, String> result = new HashMap<String, String>();
        if (parameters == null || parameters.size() <= 0) {
            return result;
        }
        for (String key : parameters.keySet()) {
            String value = parameters.get(key);
            if (value == null || "".equals(value) || "sign".equalsIgnoreCase(key)) {
                continue;
            }
            result.put(key, value);
        }
        return result;
    }

    /**
     * 参数按照字典顺序排序并按规则连接
     *
     * @param parameters
     * @return
     */
    private static String linkParameters(Map<String, String> parameters) {
        List<String> keys = new ArrayList<String>(parameters.keySet());
        // 将参数按照字典顺序排序
        Collections.sort(keys);
        StringBuilder linkedContent =new  StringBuilder("");
        int size = keys.size();
        for (int i = 0; i < size; i++) {
            String key = keys.get(i);
            String value = parameters.get(key);
            if (i == keys.size() - 1) {
                linkedContent.append(key + "=" + value);
            } else {
                linkedContent.append(key + "=" + value + "&");
            }
        }
        return linkedContent.toString();
    }

    public static class MD5 {
        /**
         * 签名字符串
         *
         * @param text 需要签名的字符串
         * @param key 签名使用的密钥
         * @param charset 编码格式
         * @return
         */
        public static String sign(String text, String key, String charset) {
            text = text + key;
            // org.apache.commons.codec.digest.DigestUtils
            try {
                return DigestUtils.md5Hex(getBytes(text, charset));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }
        /**
         * 获取字节数组
         *
         * @param content
         * @param charset
         * @return
         * @throws UnsupportedEncodingException
         */
        private static byte[] getBytes(String content, String charset) throws
                UnsupportedEncodingException {
            if (charset == null || "".equals(charset)) {
                return content.getBytes();
            }
            return content.getBytes(charset);
        }
    }
}