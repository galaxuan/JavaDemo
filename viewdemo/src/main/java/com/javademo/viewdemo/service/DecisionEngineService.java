package com.javademo.viewdemo.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "${decisionEngine.url}",name="engine")
public interface DecisionEngineService {

    @RequestMapping(value = "/decision/person",method = RequestMethod.GET)
    public JSONObject getEngineMesasge(@RequestParam("uid") String uid, @RequestParam("productCode") String productCode);

}