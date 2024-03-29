package com.springbootdatajpa.controller;

import com.springbootdatajpa.entity.Dept;
import com.springbootdatajpa.entity.Emp;
import com.springbootdatajpa.respository.DeptRespository;
import com.springbootdatajpa.respository.EmpRespsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Transactional(rollbackFor = Exception.class)
public class EmpController {

    @Autowired
    private EmpRespsitory empRespsitory;

    @Autowired
    private DeptRespository deptRespository;

    @GetMapping("/{id}")
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Emp findById(@PathVariable("id") Integer id) {
        return empRespsitory.findById(id).get();
    }

    @GetMapping("/imp")
    public void imp() {
        for (int i = 0; i < 10; i++) {
            Emp emp = new Emp();
            emp.setComm(0f);
            emp.setEname("wang" + i);
            emp.setHiredate(new Date());
            emp.setJob("teacher");
            emp.setMgr(null);
            emp.setSal(i * 10f);
            Dept d = deptRespository.findById(10).get();
            emp.setDept(d);
            empRespsitory.saveAndFlush(emp);
        }
    }
}