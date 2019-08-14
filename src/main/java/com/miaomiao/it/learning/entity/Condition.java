package com.miaomiao.it.learning.entity;

import java.util.List;

public class Condition {
	private Integer deptno;
	private Double salary;
	private List<Integer> empnos;
	public Condition() {
		super();
	}
	public Condition(Integer deptno, Double salary, List<Integer> empnos) {
		super();
		this.deptno = deptno;
		this.salary = salary;
		this.empnos = empnos;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public List<Integer> getEmpnos() {
		return empnos;
	}
	public void setEmpnos(List<Integer> empnos) {
		this.empnos = empnos;
	}
	@Override
	public String toString() {
		return "Condition [deptno=" + deptno + ", salary=" + salary + ", empnos=" + empnos + "]";
	}
	
	
}
