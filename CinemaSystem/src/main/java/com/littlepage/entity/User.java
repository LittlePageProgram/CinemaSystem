package com.littlepage.entity;
/**
 * 用户实体类
 * @author 74302
 *
 */
public class User {
	private int id;
	private String loginName;
	private String password;
	private String role;
	public User() {
		super();
	}
	public User(int id, String loginName, String password, String role) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.password = password;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", loginName=" + loginName + ", password=" + password + ", role=" + role + "]";
	}
}
