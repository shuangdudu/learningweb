package com.miaomiao.it.learning.service;

import org.apache.log4j.Logger;

public class TestLog {
	private static final Logger log = Logger.getLogger(TestLog.class);
	public static void main(String[] args) {
		 String str = "is ok";
		 log.info("-------------------"+str+"-------------------");
	}
}
