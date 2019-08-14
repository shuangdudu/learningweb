package com.miaomiao.it.learning.testJson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.miaomiao.it.learning.entity.School;
import com.miaomiao.it.learning.entity.Student;
import com.miaomiao.it.learning.entity.User;



public class TranformJson {
	//List集合转换成json代码
	@Test
	public void json2JsonObject(){
		//{\"name\":\"lina\"}
		String str = "{\"name\":\"lina\",\"id\":\"01\"}";
		JSONObject object = JSON.parseObject(str);
		System.out.println(object);
		System.out.println(object.get("name"));
	}
	@Test
	public void json2JavaBean(){
		String str = "{\"name\":\"lina\",\"id\":\"01\"}";
		User user = JSON.parseObject(str,User.class);
		System.out.println(user);
	}
	@Test
	public void json2JsonArray(){
		String s = "[{\"id\":\"17051801\",\"name\":\"lucy\"},{\"id\":\"17051802\",\"name\":\"peter\"}]";
		JSONArray array = JSON.parseArray(s);
		System.out.println(array);
		for(int i=0;i<array.size();i++){
			System.out.println(array.get(i));
			JSONObject obj = JSON.parseObject(array.get(i)+"");
			System.out.println(obj.get("name"));
		}
	}
	@Test
	public void json2JavaBeanList(){
		String s = "[{\"id\":\"17051801\",\"name\":\"lucy\"},{\"id\":\"17051802\",\"name\":\"peter\"}]";
		List<User> list = JSON.parseArray(s, User.class);
		for(User user:list){
			System.out.println(user);
		}
	} 
	@Test
	public void javaBean2Json(){
		User user = new User("17051801","lucy");
		JSONObject json = (JSONObject) JSON.toJSON(user);
		System.out.println(json);
		System.out.println(json.get("name"));
	}
	@Test
	public void json2ListInMap(){
		 String s = "{json:[{id:\"17051801\",\"name\":\"lucy\"},{id:\"17051802\",\"name\":\"peter\"},"
				 + "{id:\"17051803\",\"name\":\"tom\"},{id:\"17051804\",\"name\":\"lily\"}]}";
		//将Json字符串转换为JSONObject对象,并取出list对象的值
		 JSONObject json = JSON.parseObject(s);
		 Object objArray = json.get("json");
		 System.out.println(objArray);

		 String str = objArray+"";
		//方式1:转换成JSONArray对象形式
		 JSONArray array = JSON.parseArray(str);
		 for(int i=0;i<array.size();i++){
			 JSONObject obj = JSON.parseObject(array.get(i)+"");
			 System.out.println(obj.get("name"));
		 }
		//方式2:转换成List<JavaBean>形式
		 List<User> users = JSON.parseArray(str,User.class);
		 for(User user:users){
			 System.out.println(user);
		 }
	}
	@Test
	public void list2JsonInMap(){
		//方式1:构建一个带有list的JavaBean对象
		School school = new School();
		school.setId("1");
		school.setName("schoolA");
		List<User> list = new ArrayList<User>();
		
		User stu1 = new User();
		stu1.setId("001");
		stu1.setName("xiaoqiang");
		
		User stu2 = new User();
		stu2.setId("002");
		stu2.setName("gangzi");
		
		list.add(stu1);
		list.add(stu2);
		school.setStudents(list);
		String result = JSON.toJSONString(school);
		System.out.println(result);
		//方式2:构建一个带有list的Map对象
		Map<String,Object>map1 = new HashMap<String,Object>();
	     map1.put("id", "17051801");
	     map1.put("name", "lucy");
	    Map<String,Object> map2 = new HashMap<String,Object>();
	    map2.put("id", "17051802");
	    map2.put("name", "peter");
	    
	    List<Map<String,Object>> list1 = new ArrayList<Map<String,Object>>();
	    list1.add(map1);
	    list1.add(map2);
	    
	    Map<String,Object> school1 = new HashMap<String,Object>();
	    school1.put("id", "1");
	    school1.put("name", "schoolA");
	    school1.put("students", list1);
	    String str2 = JSON.toJSONString(school1);
	    System.out.println(str2);
	    
		
		
	}
}
