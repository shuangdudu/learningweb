package com.miaomiao.it.learning.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.miaomiao.it.learning.entity.Condition;
import com.miaomiao.it.learning.entity.Emp;

public interface EmpDao {
	List<Emp> findAllEmp();

	List<Emp> findByDept1(Integer deptno);

	List<Emp> findBySalary(Emp emp);

	List<Emp> findByDeptAndSalary(Condition con);

	int updateByDeptno(Emp emp);

	List<Emp> findByDeptnoAndEname(Condition con);

	List<Emp> findByIds(List<Integer> empnos);
}
