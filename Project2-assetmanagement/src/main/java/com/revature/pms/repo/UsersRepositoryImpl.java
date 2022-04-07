package com.revature.pms.repo;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.pms.bean.Users;

@Repository("UsersRepository")
public class UsersRepositoryImpl implements UsersRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addUsers(Users Users) {
		sessionFactory.getCurrentSession().saveOrUpdate(Users);
	}

	@SuppressWarnings("unchecked")
	public List<Users> listUsers() {
		return (List<Users>) sessionFactory.getCurrentSession().createCriteria(Users.class).list();
	}

	public Users getUsers(int userid) {
		return (Users) sessionFactory.getCurrentSession().get(Users.class, userid);
	}

	public void deleteUsers(Users users) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Users WHERE userid = "+users.getId()).executeUpdate();
	}

}
