package com.miaomiao.it.learning.entity;

import java.util.Date;

public class ProcedurePojo {
	private String roleName = null;
	private Integer result = 0;
	private Date execDate;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public Date getExecDate() {
		return execDate;
	}
	public void setExecDate(Date execDate) {
		this.execDate = execDate;
	}

	
}
