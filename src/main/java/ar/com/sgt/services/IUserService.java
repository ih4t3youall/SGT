package ar.com.sgt.services;

import ar.com.sgt.security.model.User;
import ar.com.sgt.security.model.UserProfile;

public interface IUserService {

	User findById(int id);
	
	User findBySso(String sso);
	
	UserProfile findUserProfileByUserId();
	
}