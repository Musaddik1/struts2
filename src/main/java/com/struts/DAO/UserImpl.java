package com.struts.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.struts.hibernate.HibernateUtil;
import com.struts.model.User;

public class UserImpl implements UserIn {

	private SessionFactory sessionFactory;

	public void registerUser(User user) {

		sessionFactory = HibernateUtil.getSession();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
		System.out.println("register successfully...");
	}

	public boolean loginUser(User user) {
		sessionFactory = HibernateUtil.getSession();
		Session session = sessionFactory.openSession();
		String sql = " from User u where u.email=:email and u.password=:password";
		Query query = session.createQuery(sql);
		query.setParameter("email", user.getEmail());

		query.setParameter("password", user.getPassword());
		User user1 = (User) query.uniqueResult();
		System.out.println(user1);
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		if (list.size() > 0) {
			session.close();
			return true;
		} else {
			return false;
		}

	}

	public boolean forgetUser(User user) {

		System.out.println("dsklfj");
		sessionFactory = HibernateUtil.getSession();
		Session session = sessionFactory.openSession();
		String sql = "from User u where u.email=:email";
		Query query = session.createQuery(sql);
		query.setParameter("email", user.getEmail());
		User user1 = (User) query.uniqueResult();
		if (user1 != null) {
			return true;
		} else {
			return false;
		}

	}

	public boolean resetUser(User user) {
		sessionFactory = HibernateUtil.getSession();
		Session session = sessionFactory.openSession();
		String sql = "from User u where u.password=:password";
		Query query = session.createQuery(sql);
		query.setParameter("password", user.getPassword());
		User user1 = (User) query.uniqueResult();
		System.out.println(user1);
		if (user1 != null) {
			session.save(user1);
			session.close();
			return true;
		} else {
			return false;
		}
	}

}
