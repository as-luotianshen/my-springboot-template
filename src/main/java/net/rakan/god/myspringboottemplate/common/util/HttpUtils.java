package net.rakan.god.myspringboottemplate.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;
import java.util.Map;

/**
 * springboot RestTemplate封装
 *
 * @author LiChangRui (1924097082@qq.com) on 2023/4/7
 */
public class HttpUtils {

    public static void main(String[] args) {


    }


    /**
     * 自定义请求头的post请求
     *
     * @param url
     * @param bodyJsonObject
     * @param headerJsonObject
     * @author LiChangRui (1924097082@qq.com) on 2023/4/7
     */
    public static String doPost(String url, JSONObject bodyJsonObject, JSONObject headerJsonObject) {
        RestTemplate restTemplate = new RestTemplate();
        //设置请求头
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json;charset=UTF-8");
        Iterator iterator = headerJsonObject.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            httpHeaders.add(entry.getKey().toString(), entry.getValue().toString());
        }

        HttpEntity<JSON> fromEntity = new HttpEntity(bodyJsonObject.toString(), httpHeaders);

        String str = restTemplate.postForObject(url, fromEntity, String.class);

        return str;
    }

    /**
     * 自定义请求头的get请求
     *
     * @param url
     * @param headerJsonObject
     * @author LiChangRui (1924097082@qq.com) on 2023/4/7
     */
    public static String doGet(String url, JSONObject headerJsonObject) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = getHeaders(headerJsonObject);
        HttpEntity request = new HttpEntity(headers);
        // 构造execute()执行所需要的参数。
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, String.class);
        ResponseExtractor<ResponseEntity<String>> responseExtractor = restTemplate.responseEntityExtractor(String.class);
        // 执行execute()，发送请求
        ResponseEntity<String> execute = restTemplate.execute(url, HttpMethod.GET, requestCallback, responseExtractor);
        return execute.getBody();
    }

    /**
     * Json转化请求头
     *
     * @author LiChangRui (1924097082@qq.com) on 2023/4/7
     */
    private static HttpHeaders getHeaders(JSONObject jsonHeaders) {
        Iterator iterator = jsonHeaders.entrySet().iterator();
        HttpHeaders headers = new HttpHeaders();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            headers.add(entry.getKey().toString(), entry.getValue().toString());
        }
        return headers;
    }
}
