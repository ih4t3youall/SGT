package ar.com.sgt.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.sgt.persistence.dao.IUserDao;
import ar.com.sgt.security.model.User;
import ar.com.sgt.security.model.UserProfile;
import ar.com.sgt.services.IUserService;

@Service
@Transactional
public class UserService implements IUserService{

	@Autowired
	private IUserDao dao;

	public User findById(int id) {
		return dao.findById(id);
	}

	public User findBySso(String sso) {
		return dao.findBySSO(sso);
	}

	@Override
	public UserProfile findUserProfileByUserId() {
		// TODO Auto-generated method stub
		return null;
	}

}
