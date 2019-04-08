package com.demo.springbootdatajpa.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo
 * @description: Dept
 * @author: wang gang
 * @create: 2019-03-27 15:00
 */
@Entity
@Table(name = "Dept")
public class Dept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deptno")
    private Integer deptno;

    @Column(name = "dname")
    private String dname;

    @Column(name = "loc")
    private String location;

    @OneToMany
    @JoinColumn(name = "deptno")
    private List<Emp> emps = new ArrayList<>();

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }
}