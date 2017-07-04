package com.services.dao;

import com.services.entity.Token;
import com.services.mapper.TokenMapper;

public class TokenDAO extends BaseDAO {

	private static TokenDAO instance = new TokenDAO();

	public static TokenDAO getInstance() {
		return instance;
	}

	public int add(Token obj) {
		TokenMapper mapper = getMapper();
		Integer id = mapper.add(obj);
		closeSessionObject();
		return id.intValue();
	}

	protected TokenMapper getMapper() {
		TokenMapper mapper = getSessionObject().getMapper(TokenMapper.class);
		return mapper;
	}
}