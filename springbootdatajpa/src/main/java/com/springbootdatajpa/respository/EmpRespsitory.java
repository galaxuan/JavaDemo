package com.springbootdatajpa.respository;

import com.springbootdatajpa.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: demo
 * @description:
 * @author: wang gang
 * @create: 2019-03-28 09:58
 */
public interface EmpRespsitory extends JpaRepository<Emp, Integer> {
}