package com.forge.bean;

import java.io.Serializable;
import java.sql.Date;

/**

*@Descrptionforge_users实体类
*/ 


public class Forge_Users  implements Serializable{
	private int userId;
	private String loginName;
	private String password;
	private String phone;
	private String email;
	private String address;
	public Forge_Users(){}
	public Forge_Users(int userId,String loginName,String password,String phone,String email,String address){
	super();
	this. userId=userId;
	this. loginName=loginName;
	this. password=password;
	this. phone=phone;
	this. email=email;
	this. address=address;
}
	public void setUserId(int userId){
	this.userId=userId;
	}
	public int getUserId(){
		return userId;
	}
	public void setLoginName(String loginName){
	this.loginName=loginName;
	}
	public String getLoginName(){
		return loginName;
	}
	public void setPassword(String password){
	this.password=password;
	}
	public String getPassword(){
		return password;
	}
	public void setPhone(String phone){
	this.phone=phone;
	}
	public String getPhone(){
		return phone;
	}
	public void setEmail(String email){
	this.email=email;
	}
	public String getEmail(){
		return email;
	}
	public void setAddress(String address){
	this.address=address;
	}
	public String getAddress(){
		return address;
	}
}

