package com.miaomiao.it.learning.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version 
 * @author xiaoshuang
 * @Description:
 * @date 2018年8月5日
 */
@Controller
public class ShSpringMVC {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@RequestMapping("/helloo1.do")
	public String hello(){
		log.debug("-------------进入hello()方法-------------");
		System.out.println("进入方法了");
		return "hello";
	}
}
