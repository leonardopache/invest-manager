package com.pache.investments.server.springboot.controller.request;

import com.pache.investments.server.springboot.model.personal.User;

public class JoinRequest {

	private String name;
	private String mail;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User toEntity() {
		User user = new User();
		user.setName(name);
		user.setUsername(mail);
		user.setPassword(password);
		return user;
	}

	@Override
	public String toString() {
		return "JoinRequest [name=" + name + ", mail=" + mail + ", password=" + password + "]";
	}

}
