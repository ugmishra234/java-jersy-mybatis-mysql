package com.services.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.services.entity.Login;
import com.services.util.DBQuery;

public interface LoginMapper extends IMapper {
	@Select(DBQuery.LOGIN_GET)
	public Login get(Login obj);

	@Select(DBQuery.MAX_ID)
	public int maxId();

	@Select(DBQuery.EXISTING_EMAIL)
	public String existingEmail(String email);

	@Insert(DBQuery.LOGIN_ADD)
	public Integer add(Login obj);

	@Select(DBQuery.GET_PASSWORD)
	public String getPassword(long loginId);
}
