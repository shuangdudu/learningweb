package com.miaomiao.it.learning.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miaomiao.it.learning.entity.Emp;




@Controller
@RequestMapping("/test")
public class JsonController {
	@RequestMapping("/test1.do")
	@ResponseBody
	public boolean test1(){
		return true;
	}
	@RequestMapping("/test2.do")
	@ResponseBody
	public Map<String,Object> test2(){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", 16);
		map.put("name", "刘备");
		return map; 
	}
	@RequestMapping("/test3.do")
	@ResponseBody
	public List<String> test3(){
		List<String> list = new ArrayList<String>();
		list.add("aaaa");
		list.add("bbbb");
		list.add("ccc");
		return list;
	}
	@RequestMapping("/test4")
	@ResponseBody
	public Emp test4(){
		Emp emp = new Emp();
		emp.setEname("Marry");
		emp.setJob("saleswomen");
		emp.setDeptno(20);
		emp.setEmpno(3333);
		return emp;
	}
	@RequestMapping("/test5.do")
	@ResponseBody
	public List<Emp> test5(){
		List<Emp> emp = new ArrayList<Emp>();
		Emp emp1 = new Emp();
		emp1.setEname("Marry");
		emp1.setJob("saleswomen");
		emp1.setDeptno(20);
		emp1.setEmpno(3333);
		emp.add(emp1);
		
		Emp emp2 = new Emp();
		emp2.setEname("Jack");
		emp2.setJob("Engineer");
		emp2.setDeptno(10);
		emp2.setEmpno(4444);
		emp.add(emp2);
		return emp;
	}
}
