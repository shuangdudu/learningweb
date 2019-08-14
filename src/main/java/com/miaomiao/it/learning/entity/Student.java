package com.miaomiao.it.learning.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;//id
	private String name;// 姓名
	private Integer age;// 年龄
	private Date birthday;// 生日
	private String address;// 地址
	private List<StudentScore> scores;


	//用户状态
	private Boolean userstate;
	public Student() {
		
	}
	public Student(String id, String name, Integer age, Date birthday, String address, Boolean userstate) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.birthday = birthday;
		this.address = address;
		this.userstate = userstate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Boolean getUserstate() {
		return userstate;
	}
	public void setUserstate(Boolean userstate) {
		this.userstate = userstate;
	}
	public List<StudentScore> getScores() {
		return scores;
	}
	public void setScores(List<StudentScore> scores) {
		this.scores = scores;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", birthday=" + birthday + ", address="
				+ address + ", userstate=" + userstate + "]";
	}
	
	
	

}
