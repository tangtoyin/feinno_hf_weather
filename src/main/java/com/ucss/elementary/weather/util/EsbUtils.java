package com.ucss.elementary.weather.util;

import com.alibaba.druid.support.json.JSONUtils;

import java.util.HashMap;


public class EsbUtils {

    //组合esb请求报文
    public static String getESBPostText(String system,String method,String parameter){
        String postText = "{\n" +
                "    \"mobileReqHeader\": {\n" +
                "        \"appInfo\": {\n" +
                "            \"appid\": \"com.rsl.test\",\n" +
                "            \"appCode\": \"tnwn\",\n" +
                "            \"verCode\": \"5\",\n" +
                "            \"platform\": \"ios\",\n" +
                "            \"verName\": \"V1.1.2\",\n" +
                "            \"userKey\": \"123456666666666666666666666666666666666666\",\n" +
                "            \"chnlCode\": \"cm360\"\n" +
                "        },\n" +
                "        \"authInfo\": {\n" +
                "            \"timeStamp\": \"20160623174245\",\n" +
                "            \"authKey\": \"2f317f1bfbda8a0bc0e4efc38fe612ef\",\n" +
                "            \"token\": \"\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"mobileReqBody\": {\n" +
                "        \"servReqInfo\": {\n" +
                "            \"system\": \""+system+"\",\n" +
                "            \"method\": \""+method+"\"\n" +
                "        },\n" +
                "        \"parameter\": {\n" + parameter +
                "        }\n" +
                "    }\n" +
                "}";
        return postText;
    }

    public static String getESBPostText2(String system,String method,String parameter){
        String postText = "{\n" +
                "    \"mobileReqHeader\": {\n" +
                "        \"appInfo\": {\n" +
                "            \"appid\": \"com.rsl.test\",\n" +
                "            \"appCode\": \"tnwn\",\n" +
                "            \"verCode\": \"5\",\n" +
                "            \"platform\": \"ios\",\n" +
                "            \"verName\": \"V1.1.2\",\n" +
                "            \"userKey\": \"123456666666666666666666666666666666666666\",\n" +
                "            \"chnlCode\": \"cm360\"\n" +
                "        },\n" +
                "        \"authInfo\": {\n" +
                "            \"timeStamp\": \"20160623174245\",\n" +
                "            \"authKey\": \"2f317f1bfbda8a0bc0e4efc38fe612ef\",\n" +
                "            \"token\": \"\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"mobileReqBody\": {\n" +
                "        \"servReqInfo\": {\n" +
                "            \"system\": \""+system+"\",\n" +
                "            \"method\": \""+method+"\"\n" +
                "        },\n" +
                "        \"parameter\": \n" + parameter +
                "        \n" +
                "    }\n" +
                "}";
        return postText;
    }

    public static Object getMobileRespBodyData(String result){
        if(result==null) {
            return null;
        }
        try {
            HashMap<String, Object> json = (HashMap<String, Object>) JSONUtils.parse(result);
            HashMap<String, Object> mobileRespBody = (HashMap<String, Object>) json.get("mobileRespBody");
            Object data = mobileRespBody.get("data");
            return data;
        }catch (Exception e){

        }
        return null;
    }

}
