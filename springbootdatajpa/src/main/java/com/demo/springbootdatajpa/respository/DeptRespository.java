package com.demo.springbootdatajpa.respository;

import com.demo.springbootdatajpa.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @program: demo
 * @description:
 * @author: wang gang
 * @create: 2019-03-27 15:24
 */
public interface DeptRespository extends JpaRepository<Dept, Integer> {

    public List<Dept> findByDname (String dname);

    @Query("select d from Dept d where d.dname = :dn order by deptno desc")
    public List<Dept> findDepts(@Param("dn") String dname);
}