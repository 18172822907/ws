package com.meicloud.ws.model;

public class User {

	public User() {
		super();
	}
	public User(String userName, String password, String email, String addr, String phone) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.addr = addr;
		this.phone = phone;
	}
	
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", email=" + email + ", addr=" + addr
				+ ", phone=" + phone + "]";
	}


	private String userName;
	private String password;
	private String email;
	private String addr;
	private String phone;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
