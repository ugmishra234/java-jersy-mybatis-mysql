package com.services.entity;

import java.io.Serializable;
import java.util.Date;

public class Login implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String email;
	private String password;
	private String role;
	private String applicationKey;
	private String developerKey;
	private int isActive;
	private Date createdAt;

	public Login(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public Login() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getApplicationKey() {
		return applicationKey;
	}

	public void setApplicationKey(String applicationKey) {
		this.applicationKey = applicationKey;
	}

	public String getDeveloperKey() {
		return developerKey;
	}

	public void setDeveloperKey(String developerKey) {
		this.developerKey = developerKey;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", email=" + email + ", password="
				+ password + ", role=" + role + ", isActive=" + isActive
				+ ", createdAt=" + createdAt + "]";
	}

}
