package com.ucss.elementary.weather.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author Smile
 * @date 2018/11/2 9:52
 */
public class RestTemplateUtil {
    @Autowired
    RestTemplate restTemplate;

    public static JSONObject postHttp(String url,String parms){
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<String>(parms, headers);
        return restTemplate.postForObject(url, formEntity, JSONObject.class);
    }
}
