package com.services.entity;

import java.io.Serializable;

import com.services.util.StatusConstants;

public class Token implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private long tokenKey;
	private long loginId;
	private String createdAt;
	private long validFor;

	public Token(long tokenKey, int loginId, long validFor) {
		this.tokenKey = tokenKey;
		this.loginId = loginId;
		this.validFor = validFor;
	}

	public Token() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getTokenKey() {
		return tokenKey;
	}

	public void setTokenKey(long tokenKey) {
		this.tokenKey = tokenKey;
	}

	public long getLoginId() {
		return loginId;
	}

	public void setLoginId(long loginId) {
		this.loginId = loginId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public long getValidFor() {
		return validFor;
	}

	public void setValidFor() {
		this.validFor = getTokenKey() + StatusConstants.TOKEN_VALID;
	}
}
