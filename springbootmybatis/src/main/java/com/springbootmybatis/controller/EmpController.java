package com.springbootmybatis.controller;

import com.springbootmybatis.entity.Emp;
import com.springbootmybatis.service.EmpService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @program: demo
 * @description:
 * @author: wang gang
 * @create: 2019-03-29 15:37
 */
@RestController
public class EmpController {

    @Resource
    private EmpService empService = null;

    @RequestMapping("/emp/{id}")
    public Emp findById(@PathVariable("id") Integer id) {
        Emp emp = empService.findById(id);
        return emp;
    }

    @RequestMapping("/emp/list")
    public List<Map> findDepts(String dname, Float sal) {

        return empService.findDepts(dname, sal);
    }


    @RequestMapping("/emp/create")
    public Emp create() {
        Emp emp = new Emp();
        emp.setComm(0f);
        emp.setEname("wang");
        emp.setHiredate(new Date());
        emp.setJob("teacher");
        emp.setMgr(null);
        emp.setSal(1000f);
        emp.setDeptno(30);
        empService.createEmp(emp);
        return emp;
    }

    @RequestMapping("/emp/update")
    public Emp update() {
        Emp emp = empService.findById(7900);
        emp.setSal(emp.getSal() * 2);
        empService.updateEmp(emp);
        return emp;
    }


    @RequestMapping("/emp/delete")
    public String delete(Integer empno) {
        empService.deleteEmp(empno);

        return "删除成功！";
    }

    @RequestMapping("/emp/hello")
    public String hello() {
        return "heoee";
    }
}