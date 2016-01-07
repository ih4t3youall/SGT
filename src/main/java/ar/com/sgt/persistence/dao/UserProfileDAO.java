package ar.com.sgt.persistence.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.com.sgt.security.model.UserProfile;

@Repository("userProfileDAO")
public class UserProfileDAO extends AbstractDao<Integer,UserProfile> implements IUserProfileDAO{ 


	
	
	
@Override
public List<UserProfile> findUserProfileByUserID(int idUser) {

	
	Criteria crit = createEntityCriteria();
	crit.add(Restrictions.eq("id", idUser));
	List<UserProfile> list =(List<UserProfile>) crit.list();
	return  list;
	

}
}