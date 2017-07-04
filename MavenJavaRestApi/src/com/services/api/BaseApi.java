package com.services.api;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.services.exception.APIException;
import com.services.util.StatusConstants;

public class BaseApi {

	protected String response;
	private int code = 0;
	private String message = "";
	
	final void genericExceptionHandler(APIException apiException) {
		setCode(apiException.getCode());
		setMessage(apiException.getMessage());
	}

	final Response getResponse() {
		Response responseObject = Response
				.status(200)
				.entity(this.response)
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT, OPTIONS")
				.header("Access-Control-Allow-Credentials", true)
				.header("Access-Control-Allow-Origin", "*").build();
		return responseObject;
	}

	final void setMessage(String msg) {
		this.message = msg;
	}

	void setCode(int code) {
		this.code = code;
	}

	private int getCode() {
		return code;
	}

	private String getMessage() {
		return message;
	}

	final void setReturnableResponse(Map<String, Object> data) {
		Map<String, String> status = new HashMap<String, String>();
		status.put("StatusCode", "" + getCode());
		status.put("StatusMessage", getMessage());

		Map<Object, Object> apiResponse = new HashMap<Object, Object>();
		apiResponse.put("Data", data);
		apiResponse.put("Status", status);

		Map<Object, Object> response = new HashMap<Object, Object>();
		response.put("Response", apiResponse);
		Gson gson = new Gson();
		this.response = gson.toJson(response);
	}

	final void setDefaultSuccess() {
		setCode(StatusConstants.SUCCESSFUL_CALL);
		setMessage(StatusConstants.SUCCESS_MESSAGE);
	}
	
	final void prepareResponse(long merchantTokenId) {
		Map<String, Long> merchantToken = new HashMap<String, Long>();
		Map<String, Object> data = new HashMap<String, Object>();
		merchantToken.put("Token", merchantTokenId);
		data.put("MerchantToken", merchantToken);
		setReturnableResponse(data);
	}

}