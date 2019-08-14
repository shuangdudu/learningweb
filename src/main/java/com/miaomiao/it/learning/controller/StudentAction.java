package com.miaomiao.it.learning.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.miaomiao.it.learning.entity.Student;
import com.miaomiao.it.learning.entity.StudentScore;
@Controller
@RequestMapping("/stu")
public class StudentAction {
	@RequestMapping("/queryStudent")
	public String queryStudent(Model model){
		List<Student> list = new ArrayList<Student>();
		Student stu1 = new Student();
		stu1.setId("s001");
		stu1.setName("liming");
		stu1.setAge(22);
		stu1.setBirthday(new Date());
		Student stu2 = new Student();
		stu2.setId("s002");
		stu2.setName("lina");
		stu2.setAge(21);
		stu2.setBirthday(new Date());
		list.add(stu1);
		list.add(stu2);
		model.addAttribute("list",list);
		return "student2";
	}
	
	@RequestMapping("/editstudent/{id}")
	public String editStudent(HttpServletRequest request,Model model,@PathVariable String id){
		System.out.println("id = "+id);
		Student stu = new Student();
		stu.setId("s001");
		stu.setName("xiaoqiang");
		stu.setAge(24);
		stu.setBirthday(new Date());
		model.addAttribute("student",stu);
		return "editstudent";
	}
	
	@RequestMapping("/editstudentsubmit")
	public String editStudentSubmit(Model model,Student student){
		System.out.println(student);
		return "forward:queryStudent.do";
	}
	@RequestMapping("/deletestu")
	public String deleteStu(String[]deleteid){
		System.out.println(deleteid.length);
		return "success";
	}
	
	@RequestMapping("/getparameter.do")
	public ModelAndView getParameter(Model model,@RequestParam Map<String,String> parameter){
		for(Map.Entry<String, String> map:parameter.entrySet()){
			System.out.println("key = "+map.getKey()+","+"value = "+map.getValue());
		}
		ModelAndView mav = new ModelAndView("success",parameter);
		return mav;
	//	return "success";
		
	}
	@InitBinder
	public void initBinder(HttpServletRequest request,ServletRequestDataBinder binder){
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), true));
	}
}
