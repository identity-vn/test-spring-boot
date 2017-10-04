package identity.passport.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import identity.passport.entity.User;


@Repository
public class UserDAO extends AbstractHibernateDAO{
	public User findByEmail(String email){
		Criteria cr = getCurrentSession().createCriteria(User.class);
		cr.add(Restrictions.eq("email", email));
		cr.add(Restrictions.eq("isDeleted", false));
		List<User> listUser = cr.list();
		if(listUser.size() > 0){
			return listUser.get(0);
		}
		return null;
	}
}
