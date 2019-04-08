package com.demo.springbootmybatis.mapper;

import com.demo.springbootmybatis.entity.Emp;

import java.util.List;
import java.util.Map;

/**
 * @program: demo
 * @description:
 * @author: wang gang
 * @create: 2019-03-29 15:21
 */
public interface EmpMapper {

    public Emp findById(Integer empno);

    public List<Map> findDepts(Map param);

    public void createEmp(Emp emp);

    public void updateEmp(Emp emp);

    public  void deleteEmp(Integer empno);
}