package com.springbootmybatis.service;

import com.springbootmybatis.entity.ProjInfo;
import com.springbootmybatis.mapper.ProjInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: demo
 * @description:
 * @author: wang gang
 * @create: 2019-03-29 15:33
 */
@Service
public class ProjInfoService {
    @Resource
    private ProjInfoMapper projInfoMapper = null;

    public ProjInfo findProjInfoByName(String projInfo) {
        return projInfoMapper.findProjInfoByName(projInfo);
    }

    public ProjInfo findProjInfoByNewCode(long newCode) {
        return projInfoMapper.findProjInfoByNewCode(newCode);
    }

}