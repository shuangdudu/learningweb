package com.miaomiao.it.learning.entity;

import java.io.Serializable;
import java.util.List;

public class UserVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//学生信息包装进来
	private Student student;
	
	//学生成绩 信息
	private List<StudentScore> scores;

	public UserVo() {

	}

	public UserVo(Student student, List<StudentScore> scores) {
		super();
		this.student = student;
		this.scores = scores;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<StudentScore> getScores() {
		return scores;
	}

	public void setScores(List<StudentScore> scores) {
		this.scores = scores;
	}

	@Override
	public String toString() {
		return "UserVo [student=" + student + ", scores=" + scores + "]";
	}
	
	
	

}
