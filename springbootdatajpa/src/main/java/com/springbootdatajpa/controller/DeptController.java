package com.springbootdatajpa.controller;

import com.springbootdatajpa.entity.Dept;
import com.springbootdatajpa.respository.DeptRespository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/dept")
public class DeptController {

    @Resource
    private DeptRespository deptRespository = null;

    @GetMapping("/{id}")
    @ResponseBody
    public Dept findById(@PathVariable("id") Integer id) {
        Optional<Dept> op = deptRespository.findById(id);
        Dept dept = null;
        if (op.isPresent()) {
            dept = op.get();
        }
        return dept;
    }


    @GetMapping("/create")
    @ResponseBody
    public Dept Create() {
        Dept d = new Dept();
        d.setDname("huang");
        d.setLocation("Beijing");
        deptRespository.save(d);
        return d;
    }

    @GetMapping("/update")
    @ResponseBody
    public Dept Update() {
        Dept d = deptRespository.findById(30).get();
        d.setDname("(" + d.getDname() + ")");
        deptRespository.save(d);
        return d;
    }

    @GetMapping("/delete")
    @ResponseBody
    public Dept Delete() {
        Dept d = deptRespository.findById(40).get();
        deptRespository.delete(d);
        return d;
    }

    @GetMapping("/find")
    @ResponseBody
    public List<Dept> findDepts(String dname) {
        List<Dept> list = deptRespository.findByDname(dname);
        return list;
    }
}