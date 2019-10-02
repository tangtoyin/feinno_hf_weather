package com.ucss.elementary.tnwn.service.tnwn;

import java.io.IOException;
import java.util.Base64;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
//import org.apache.http.entity.mime.MultipartEntityBuilder;
//import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

public class HttpClientWithBasicAuth  {


   /* public int httpClientWithBasicAuth(String username, String password, String uri, Map<String, String> paramMap) {

        try {
            // 创建HttpClientBuilder
            HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
            CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
            HttpPost httpPost = new HttpPost(uri);

            //添加http头信息
            httpPost.addHeader("Authorization", "Basic " + Base64.getUrlEncoder().encodeToString((username + ":" + password).getBytes()));

            MultipartEntityBuilder builder = MultipartEntityBuilder.create();

            paramMap.forEach((k,v)->{
                builder.addPart(k, new StringBody(v, ContentType.MULTIPART_FORM_DATA));
            });

            HttpEntity postEntity = builder.build();
            httpPost.setEntity(postEntity);

            String result = "";

            HttpResponse httpResponse = null;
            HttpEntity entity = null;
            try {

                httpResponse = closeableHttpClient.execute(httpPost);

                entity = httpResponse.getEntity();

                if( entity != null ){

                    result = EntityUtils.toString(entity);

                }

            } catch (ClientProtocolException e) {

                e.printStackTrace();

            } catch (IOException e) {

                e.printStackTrace();

            }

            // 关闭连接
            closeableHttpClient.close();

        }catch (Exception e) {

            System.out.println(e.getStackTrace());

        }
        return 0;

    }*/


}