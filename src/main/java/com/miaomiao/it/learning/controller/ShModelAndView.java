package com.miaomiao.it.learning.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 处理器类。
 *   要求如下：
 *   1.实现Controller接口。
 *	 2.将业务处理代码写在handleRequest
 *		方法当中。
 *   3.也可以将业务处理代码写在其它java类
 *   里面,然后由处理器去调用。
 */

/**
 * @version 
 * @author xiaoshuang
 * @Description: 
 * @date 2018年8月5日
 */
public class ShModelAndView implements Controller{
	@RequestMapping("/helloo2")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ShModelAndView 的 handleRequest()...");
		/*
		 * ModelAndView有两个构造器。
		 * 1. ModelAndView(String viewName)。
		 * 2. ModelAndView(String viewName,
		 * Map data)。
		 * 注：
		 * viewName:视图名。
		 * data:处理结果。
		 */
		return new ModelAndView("hello");
	}

}
