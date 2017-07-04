package com.services.dao;

import com.services.entity.Login;
import com.services.mapper.LoginMapper;

public class LoginDAO extends BaseDAO {

	private static LoginDAO instance = new LoginDAO();

	public static LoginDAO getInstance() {
		return instance;
	}

	public int add(Login obj) {
		LoginMapper mapper = getMapper();
		Integer id = mapper.add(obj);
		closeSessionObject();
		return id.intValue();
	}

	public Login get(Login obj) {
		LoginMapper mapper = getMapper();
		Login login = mapper.get(obj);
		closeSessionObject();
		return login;
	}

	protected LoginMapper getMapper() {
		LoginMapper mapper = getSessionObject().getMapper(LoginMapper.class);
		return mapper;
	}

	public int maxId() {
		LoginMapper mapper = getMapper();
		int lastId = mapper.maxId();
		closeSessionObject();
		return lastId;
	}

	public String existingEmail(String email) {
		LoginMapper mapper = getMapper();
		String existingsEmail = mapper.existingEmail(email);
		closeSessionObject();
		return existingsEmail;
	}

	public String getPassword(long loginId) {
		LoginMapper mapper = getMapper();
		String password = mapper.getPassword(loginId);
		closeSessionObject();
		return password;
	}

}
