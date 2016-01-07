package ar.com.sgt.persistence.dao;

import ar.com.sgt.security.model.User;

public interface IUserDao {

	User findById(int id);
	
	User findBySSO(String sso);
	
}

