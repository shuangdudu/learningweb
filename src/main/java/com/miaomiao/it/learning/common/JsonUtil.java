package com.miaomiao.it.learning.common;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
/*
 * 对类的功能的详细描述。如有必要请使用简单样例进行说明
 */
public class JsonUtil {
	private static Gson gson = null;
	static{
		if(gson == null){
			gson = new Gson();
		}
	}
	private JsonUtil(){
		
	}
	public static <T> T parseObject(String jsonData,Class<T> clas){
		if(null == gson){
			return null;
		}
		return gson.fromJson(jsonData, clas);
	}
	//讲json数组解析成相应的映射对象列表
	public static <T> List<T> parseJsonArrayWithGson(String jsonData,Class<T> clas){
		if(null == gson){
			return null;
		}
		Type type = new TypeToken<List<T>>(){}.getType();
		return gson.fromJson(jsonData, type);
		
	}
	public static String toJSONString(Object o){
		if(null == gson){
			return null;
		}
		return gson.toJson(o);
	}
}
