package com.services.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.services.entity.Merchant;
import com.services.util.DBQuery;

public interface MerchantMapper extends IMapper {

	@Insert(DBQuery.MERCHANT_ADD)
	public Integer add(Merchant obj);

	@Select(DBQuery.EXISTING_MERCHANT_MOBILE)
	public String existingMerchantMobile(String mobileNo);

}
