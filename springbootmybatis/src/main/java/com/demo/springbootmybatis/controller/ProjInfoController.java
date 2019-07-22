package com.demo.springbootmybatis.controller;

import com.demo.springbootmybatis.entity.ProjInfo;
import com.demo.springbootmybatis.service.ProjInfoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: demo
 * @description:
 * @author: wang gang
 * @create: 2019-03-29 15:37
 */
@RestController
public class ProjInfoController {

    @Resource
    private ProjInfoService projInfoService = null;

    @RequestMapping("/findProjInfoByName/{name}")
    public ProjInfo findProjInfoByName(@PathVariable("name") String name) {
        ProjInfo projInfo = projInfoService.findProjInfoByName(name);
        return projInfo;
    }

    @RequestMapping("/findProjInfoByNewCode/{newcode}")
    public ProjInfo findProjInfoByNewCode(@PathVariable("newcode") long newcode) {
        ProjInfo projInfo = projInfoService.findProjInfoByNewCode(newcode);
        return projInfo;
    }
}