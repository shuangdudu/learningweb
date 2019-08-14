package com.miaomiao.it.learning.common;

import java.util.HashMap;
import java.util.Map;

public class MapConstant {
	private static final Map<String,String> dataMap = new HashMap<String, String>();	
	static{
		dataMap.put("DLU", "大理机场");
		dataMap.put("DIG", "迪庆香格里拉机场");
		dataMap.put("TCZ", "腾冲（驼峰）机场");
		dataMap.put("LJG", "丽江机场");
		dataMap.put("BSD", "保山机场");
		dataMap.put("JHD", "西双版纳机场");
		dataMap.put("SYM", "普洱机场");
		dataMap.put("KMG", "昆明机场");
		dataMap.put("ZAT", "昭通机场");
		dataMap.put("LUM", "芒市机场");
		dataMap.put("LNJ", "临沧机场");
		dataMap.put("WNH", "文山机场");
	}
}
