package com.miaomiao.it.learning.entity;

import java.io.Serializable;
import java.util.List;

public class School implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private List<User> students;
	public School() {
		
	}
	public School(String id, String name, List<User> students) {
		this.id = id;
		this.name = name;
		this.students = students;
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
	public List<User> getStudents() {
		return students;
	}
	public void setStudents(List<User> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "School [id=" + id + ", name=" + name + ", students=" + students + "]";
	}
	
	
	
	
	
	
}
