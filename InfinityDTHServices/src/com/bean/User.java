package com.bean;

public class User {
	public static final Integer ADMIN = 1;
	public static final Integer OPERATOR = 2;
	public static final Integer RETAILER = 3;
	public static final Integer CUSTOMER = 4;
	
	private Integer userId;
	private String username;
	private String password;
	private Integer roleId;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}
