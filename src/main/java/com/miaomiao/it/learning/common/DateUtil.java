package com.miaomiao.it.learning.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtil {
	private static final Logger log = LoggerFactory.getLogger(DateUtil.class);
	
	/**
	 * @version 
	 * @author xiaoshuang
	 * @Description:定义时间格式
	 * @date 2018年9月6日
	 */
	public enum DateFormat{
		YYYY_MM_DD_HH_mm_ss("yyyy-MM-dd HH:mm:ss"),
		YYYY_MM_DD("yyyy-MM-dd"),
		YYYYMMDDHHMMSS("yyyyMMddHHmmss");
		
		private String value;
		DateFormat(String value){
			this.value = value;
		}
		public String getValue(){
			return this.value;
		}
	}
	
	/**
	 * @author xiaoshuang
	 * @Description :获取当前时间
	 * @date 2018年9月6日
	 * @param dateFormat
	 * @return
	 */
	public String getCurrentTime(DateFormat dateFormat){
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat.getValue());
		Date date = new Date();
		return sdf.format(date);
	}

	/**
	 * @desc java.util.Date 转化为 java.sql.Date     java.sql.Date 是 java.util.Date的子类
	 * @param date
	 * @return
	 */
	public java.sql.Date utilDateToSqlDate(java.util.Date date){
		return new java.sql.Date(date.getTime());
	}

	/**
	 * desc java.sql.Date 转化为 java.util.Date
	 * @param date
	 * @return
	 */
	public java.util.Date sqlDateToUtilDate(java.sql.Date date){
		return new java.util.Date(date.getTime());
	}

	public String dateToString(Date date,String format){
		if(date == null){
			date = new Date();
		}
		if(StringUtils.isBlank(format)){
			format = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

	public static void main(String[] args) {
		java.sql.Date date = new java.sql.Date(new Date().getTime());
		System.out.println();
	}
	
}
