package com.lisovitskiy.pojos;

import java.util.Date;

public class User {
	private int id;
	private String username;
	private char[] password;
	private String mail;
	private Date dateOfBirth;
	private int role;

	public User(int id, String login, char[] password, String mail, Date dateOfBirth, int role) {
		super();
		this.id = id;
		this.username = login;
		this.password = password;
		this.mail = mail;
		this.dateOfBirth = dateOfBirth;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}


}
