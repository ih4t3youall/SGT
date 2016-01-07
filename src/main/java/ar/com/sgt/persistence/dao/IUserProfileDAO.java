package ar.com.sgt.persistence.dao;

import java.util.List;

import ar.com.sgt.security.model.UserProfile;

public interface IUserProfileDAO {

	public List<UserProfile> findUserProfileByUserID(int idUser);
	
}
