package com.springclound.client.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

//直接通过restTemplate调接口的demo
@RestController
@RequestMapping("/test")
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String test(){
       // ResponseEntity<String> stringResponseEntity = restTemplate.getForEntity("http://localhost:8001/hello",  String.class);


        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("aa","aa");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("application/json;UTF-8"));
        HttpEntity<String> httpEntity = new HttpEntity<>(JSON.toJSONString(paramMap),headers);
        //postForEntity与postForObject 区别：postForObject直接返回json出参，postForEntity还有其它参数，需要getBody
        ResponseEntity<String> response2 = restTemplate.postForEntity("http://s1:8001/hello", httpEntity, String.class);
        return response2.getBody();
    }


}
