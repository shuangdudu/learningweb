package com.miaomiao.it.learning.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.miaomiao.it.learning.entity.Condition;
import com.miaomiao.it.learning.entity.Emp;



@Repository
public interface EmpDao1 {
	List<Emp> findAll();
	List<Emp> findByDept(Condition cond);
}
