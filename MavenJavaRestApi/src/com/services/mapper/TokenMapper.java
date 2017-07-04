package com.services.mapper;

import org.apache.ibatis.annotations.Insert;

import com.services.entity.Token;
import com.services.util.DBQuery;

public interface TokenMapper extends IMapper {

	@Insert(DBQuery.TOKEN_ADD)
	public Integer add(Token obj);

}
