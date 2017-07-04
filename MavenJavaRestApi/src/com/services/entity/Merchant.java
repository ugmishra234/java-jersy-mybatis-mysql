package com.services.entity;

import java.io.Serializable;

public class Merchant implements Serializable {

	private static final long serialVersionUID = 1L;

	private long merchantId;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private int loginId;
	private String mobileNo;
	private String applicationKey;
	private String developerKey;

	public Merchant(String email, String firstName, String lastName,
			String mobileNo, String password, String applicationKey,
			String developerKey) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.password = password;
		this.applicationKey = applicationKey;
		this.developerKey = developerKey;
	}

	public Merchant() {

	}

	public long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(long merchantId) {
		this.merchantId = merchantId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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
}
