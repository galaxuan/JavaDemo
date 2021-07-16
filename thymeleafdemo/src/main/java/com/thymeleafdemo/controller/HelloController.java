package com.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author wanggang
 */
@Controller
public class HelloController {

    @RequestMapping("index")
    public String index(Map<String, Object> map) {
        map.put("text", "哈哈");
        return "/index";
    }
}