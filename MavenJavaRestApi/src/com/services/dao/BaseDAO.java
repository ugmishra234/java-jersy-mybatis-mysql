package com.services.dao;

import org.apache.ibatis.session.SqlSession;

import com.services.mapper.IMapper;
import com.services.util.DBAccess;

public abstract class BaseDAO {

	private static SqlSession session = null;

	protected synchronized SqlSession getSessionObject() {
		if (session == null) {
			session = DBAccess.getSession().openSession();
		}
		return session;
	}

	protected void closeSessionObject() {
		session.commit();
	}

	abstract protected IMapper getMapper();
}
