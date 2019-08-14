package com.miaomiao.it.learning.entity;

import java.io.Serializable;

public class StudentScore implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String coursename;//课程名称
	private Float score;//成绩
	public StudentScore() {

	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public Float getScore() {
		return score;
	}
	public void setScore(Float score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "StudentScore [coursename=" + coursename + ", score=" + score + "]";
	}
	
	

}
