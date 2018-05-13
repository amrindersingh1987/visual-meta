package com.visualmeta.model;

import java.io.Serializable;

public class UserInfoModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	
	private String username;
	
	private String firstName;

	private String lastName;
	
	private String accessToken;
	
	public UserInfoModel(int id, String username, String firstName, String lastName, String accessToken) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accessToken = accessToken;
	}

	public UserInfoModel() {
		super();
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}


	

}
