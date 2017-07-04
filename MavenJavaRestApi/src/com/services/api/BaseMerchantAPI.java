package com.services.api;

import java.util.HashMap;
import java.util.Map;

public class BaseMerchantAPI extends BaseApi {
	Map<String, Object> data = new HashMap<String, Object>();
	Map<String, Object> responseMap = new HashMap<String, Object>();

	public void createResponse(long merchantTokenId) {
		responseMap.put("AuthToken", merchantTokenId);
		data.put("MerchantToken", responseMap);
		setReturnableResponse(data);
	}

}
