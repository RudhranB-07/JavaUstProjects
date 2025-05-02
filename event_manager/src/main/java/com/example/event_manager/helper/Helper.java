package com.example.event_manager.helper;

public class Helper {

	private String email;
	private String password;
	public Helper(String email, String password) {
		
		this.email = email;
		this.password = password;
	}
	public Helper() {
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
