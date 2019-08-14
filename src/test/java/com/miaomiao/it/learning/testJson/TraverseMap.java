package com.miaomiao.it.learning.testJson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class TraverseMap {

	// jdk 1.4中遍历方法
	// 遍历方法一：hasMap().entrySet()
	@Test
	public void testMap1() {
		System.out.println("方法一：");
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		Iterator<Entry<String, Integer>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("key = " + key + ";" + "value = " + value);
		}

	}

	@Test
	public void testMap2() {
		System.out.println("方法二：");
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		for (Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("key = " + key + ";" + "value = " + value);
		}

	}

	@Test
	public void testMap3() {
		System.out.println("方法四：");
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		System.out.println("方法三：");
		for (Iterator<String> iterator = map.keySet().iterator(); iterator.hasNext();) {
			String key = iterator.next();
			System.out.println("key = " + key);
		}
		for (Iterator<Integer> iterator = map.values().iterator(); iterator.hasNext();) {
			Integer value = iterator.next();
			System.out.println("value = " + value);
		}
	}
	// java是如何遍历Map<String,ArrayList> map = new
	// HashMap<String,ArrayList<Integer>>();

	@Test
	public void testMap4() {
		System.out.println("java是如何遍历Map<String,ArrayList> map = new HashMap<String,ArrayList<Integer>>();");
		Map<String, List<Integer>> mapList = new HashMap<String, List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		mapList.put("aaa", list);
		mapList.put("bbb", list);
		Iterator<String> iterator = mapList.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println("key = " + key);
			List<Integer> arrList = mapList.get(key);
			for (Integer intValue : arrList) {
				System.out.println("intValue = " + intValue);
			}

		}

	}

	@Test
	public void testMap5() {
		System.out.println("java是如何遍历Map<String,ArrayList> map = new HashMap<String,ArrayList<Integer>>();");
		Map<String,List<Integer>>mapList = new HashMap<String,List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		mapList.put("a", list);
		mapList.put("b", list);
		for(Entry<String,List<Integer>>entry:mapList.entrySet()){
			String key = entry.getKey();
			System.out.println("key = "+key);
			List<Integer> values = entry.getValue();
			for(Integer value:values){
				System.out.println("value = "+value);
			}
		}
	}
}
