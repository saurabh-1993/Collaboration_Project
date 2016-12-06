package com.niit.collaboration.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();

			return false;
		}
	}

	@Transactional
	public boolean update(User user) {

		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			// TODO Auto-generated method stub
			return false;
		}
	}

	@Transactional
	public boolean delete(User user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public List<User> list() {
		String hql = "from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Transactional
	public User get(String id) {
		String hql = "from User where id = " + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
	
		List<User> list = query.list();
		if (list == null) {
			return null;
		} else {
			return list.get(0);
		}

	}
@Transactional
	public User authenticate(String id, String password) {
		String hql = "from User where id= '" + id + "' and " + " password ='" + password+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		if(list == null){
			return null;
		}
		else{
		return list.get(0);
		}
	}

	public boolean userExist(User user) {
		// TODO Auto-generated method stub
		return false;
	}


	

}
