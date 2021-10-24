package com.ujin.test.model;

public class MemberDto {
	private String userid;
	private String pwd;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	
	@Override
	public String toString() {
		return "MemberDto [userid=" + userid + ", pwd=" + pwd + "]";
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
