package com.services.dao;

import com.services.entity.Merchant;
import com.services.mapper.MerchantMapper;

public class MerchantDAO extends BaseDAO {

	private static MerchantDAO instance = new MerchantDAO();

	public static MerchantDAO getInstance() {
		return instance;
	}

	public int add(Merchant obj) {
		MerchantMapper mapper = getMapper();
		Integer id = mapper.add(obj);
		closeSessionObject();
		return id.intValue();
	}
	
	public String existingMerchantMobile(String mobileNo) {
		MerchantMapper mapper = getMapper();
		String existingsMobileNo = mapper.existingMerchantMobile(mobileNo);
		closeSessionObject();
		return existingsMobileNo;
	}

	protected MerchantMapper getMapper() {
		MerchantMapper mapper = getSessionObject().getMapper(
				MerchantMapper.class);
		return mapper;
	}

}