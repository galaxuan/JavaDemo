package com.demo.springbootmybatis.service;

import com.demo.springbootmybatis.entity.Emp;
import com.demo.springbootmybatis.mapper.EmpMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: demo
 * @description:
 * @author: wang gang
 * @create: 2019-03-29 15:33
 */
@Service
public class EmpService {
    @Resource
    private EmpMapper empMapper = null;

    public Emp findById(Integer empno) {
        return empMapper.findById(empno);
    }

    public List<Map> findDepts(String dname, Float sal) {
        Map param = new HashMap(2);
        param.put("dname", dname);
        param.put("sal", sal);
        return empMapper.findDepts(param);
   }

    @Transactional(rollbackFor = Exception.class)
    public void createEmp(Emp emp) {
        empMapper.createEmp(emp);
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateEmp(Emp emp) {
        empMapper.updateEmp(emp);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteEmp(Integer empno) {
        empMapper.deleteEmp(empno);
    }
}