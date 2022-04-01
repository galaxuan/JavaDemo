package com.springbootdatajpa.respository;

import com.springbootdatajpa.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRespsitory extends JpaRepository<Emp, Integer> {
}