package com.services.util;

public class StatusConstants {

	public static final int SUCCESSFUL_CALL = 0;
	public static final int FAILED_CALL = 1;
	public static final int INVALID_TOKEN = 3;
	public static final int EXISTING_MOBILE_NUMBER = 13;
	public static final int INVALID_PASSWORD_CODE = 13;
	public static final int INVALID_EMAIL_CODE = 13;
	public static final int INVALID_MOBILE_NUMBER = 12;
	public static final int INVALID_EMAIL = 9;
	public static final long TOKEN_VALID = 12000000;

	public static final String SUCCESS_MESSAGE = "Method call successful";
	public static final String NO_RECORD_MESSAGE = "No record found";
	public static final String UPDATE_FAIL = "Record not updated";
	public static final String INVALID_TOKEN_MESSAGE = "Invalid or expired consumer token";
	public static final String INVALID_MERCHANT_TOKEN = "Invalid merchant token";
	public static final String EXPIRED_MERCHANT_TOKEN = "Eexpired merchant token";
	public static final String VALIDATION_MESSAGE = "Data in the request is either empty or of invalid format";
	public static final String INVALID_EMAIL_PASSWORD_MESSAGE = "Invaild email or password";
	public static final String EXISTING_MOBILE_NUMBER_MESSAGE = "Mobile number must be unique";
	public static final String INVALID_MOBILE_NUMBER_MESSAGE = "Invalid Mobile Number format.it must be 10 digits";
	public static final String INVALID_EMAIL_MESSAGE = "Invalid Email address";
	public static final String UNIQUE_EMAIL_ID = "Email id must be unique";
	public static final String INVALID_PASSWORD = "Password does not comply with the password rule - must be at least six characters, containing atleast one character and one digit";
	public static final String NOT_ALIVE = "Session is not alive, Login again";

}
