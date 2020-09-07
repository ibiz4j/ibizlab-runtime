package cn.ibizlab.util.helper;

import com.alibaba.fastjson.JSONObject;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;

/**
 * 请求工具类
 */
public class HttpUtils {

    private final static String DEFAULT_ENCODING = "UTF-8";
    /**
     * Post请求
     *
     * @return
     */
    public static String post(String url) {
        return post(url,null,null);
    }

    /**
     *Post请求
     * @param
     * @return
     */
    public static String post(String url,JSONObject headerMap,JSONObject paramMap) {
        return doRestRequest(url,HttpMethod.POST,headerMap,paramMap);
    }

    /**
     *put请求
     * @param
     * @return
     */
    public static String put(String url, JSONObject headerMap,JSONObject paramMap) {
        return doRestRequest(url,HttpMethod.PUT,headerMap,paramMap);
    }

    /**
     * GET请求
     *
     * @param
     * @return
     */
    public static String get(String url) throws UnsupportedEncodingException {
       return get(url,null,null);
    }

    /**
     * GET请求
     *
     * @param
     * @param
     * @return
     */
    public static String get(String url, JSONObject headerMap,JSONObject paramMap) throws UnsupportedEncodingException {
        if(paramMap !=null){
            boolean flag = true;
            for(String key : paramMap.keySet()){
                if(flag){
                    url += "?";
                }else{
                    url += "&";
                }
                flag = false;
                url = url + key + "=" + URLEncoder.encode(paramMap.getString(key),DEFAULT_ENCODING);
            }
        }
        return doRestRequest(url,HttpMethod.GET,headerMap,paramMap);
    }

    /**
     * DELETE请求
     *
     * @param
     * @return
     */
    public static String delete(String url) {
       return delete(url,null,null);
    }

    /**
     * DELETE请求
     *
     * @param
     * @param
     * @return
     */
    public static String delete(String url, JSONObject headerMap,JSONObject paramMap) {
      return doRestRequest(url,HttpMethod.DELETE,headerMap,paramMap);
    }

    public static String doRestRequest(String url, HttpMethod method, JSONObject headerMap, JSONObject paramMap){
        RestTemplate restTemplate = getRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        if(headerMap!=null){
            for(String key : headerMap.keySet()){
                headers.add(key,headerMap.getString(key));
            }
        }
        MultiValueMap<String,String> params = new LinkedMultiValueMap<String,String>();
        HttpEntity<String> entity;
        if(paramMap!=null){
            entity = new HttpEntity<>(paramMap.toString(), headers);
        }else{
            entity = new HttpEntity<>(null, headers);
        }
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, method, entity, String.class);
        return responseEntity.getBody();
    }

    public static InputStream requestInputStream(String url, JSONObject headerMap, JSONObject paramMap) throws IOException {
        RestTemplate restTemplate = getRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        if(headerMap!=null){
            for(String key : headerMap.keySet()){
                headers.add(key,headerMap.getString(key));
            }
        }
        MultiValueMap<String,String> params = new LinkedMultiValueMap<String,String>();
        HttpEntity<String> entity;
        if(paramMap!=null){
            entity = new HttpEntity<>(paramMap.toString(), headers);
        }else{
            entity = new HttpEntity<>(null, headers);
        }
        ResponseEntity<Resource> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, Resource.class);
        return responseEntity.getBody().getInputStream();
    }

    public static RestTemplate getRestTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        for (HttpMessageConverter<?> httpMessageConverter : restTemplate.getMessageConverters()) {
            if (httpMessageConverter instanceof StringHttpMessageConverter) {
                ((StringHttpMessageConverter) httpMessageConverter).setDefaultCharset(Charset.forName("UTF-8"));
                break;
            }
        }
        return restTemplate;
    }
}

