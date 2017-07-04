package com.services.exception;

public class APIException extends Exception {

	private static final long serialVersionUID = 1L;

	private int code = 0;

	public APIException(int _code, String _message) {
		super(_message);
		code = _code;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return super.getMessage();
	}
}
