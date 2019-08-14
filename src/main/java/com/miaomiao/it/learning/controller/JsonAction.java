package com.miaomiao.it.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miaomiao.it.learning.entity.Student;

@Controller
public class JsonAction {
	@RequestMapping("/requestJson")
	@ResponseBody
	public Student requestJson(@RequestBody Student student){
		System.out.println(student);
		return student;
	}
	@RequestMapping("/responseJson")
	@ResponseBody
	public Student responseJson(Student student){
		System.out.println(student);
		return student;
	}
}
