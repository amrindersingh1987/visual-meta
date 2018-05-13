package com.visualmeta.model;

import java.io.Serializable;

public class UserPostModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String text;
	
	private String title;
	
	private String description;

	
	private int userId;
	
	public UserPostModel() {
		super();
	}


	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

}
