package com.miaomiao.it.learning.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;





/**
 * @version 
 * @author xiaoshuang
 * @Description:
 * @date 2018年8月15日
 * 该方式只能读取类路径下的配置文件，有局限但是如果配置文件在类路径下比较方便
 */
public class PropertityUtil {
	private static final Logger logger = Logger.getLogger(PropertityUtil.class);
	private static HashMap<String,Properties> map = null;
	public static String get(String fileName,String key){
		String propertyPath = "conf-properties/"+fileName+".properties";
		if(map == null){
			map = new HashMap<String,Properties>();
		}
		if(map.get(fileName)!=null){
			return map.get(fileName).get(key)==null?null:map.get(fileName).get(key).toString();
		}
		InputStream is = PropertityUtil.class.getClassLoader().getResourceAsStream(fileName);
		Properties propertie = new Properties();
		logger.error(propertyPath);
		logger.error("is:"+(is == null));
		try {
			propertie.load(is);
			map.put(fileName, propertie);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return map.get(fileName).get(key)==null?null:map.get(fileName).get(key).toString();
	}
}
