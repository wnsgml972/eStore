package kr.ac.hansung.cse.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.hansung.cse.model.User;

@Repository
@Transactional
public class UserDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User getUserById(int userId) {

		Session session = sessionFactory.getCurrentSession();
		User User = (User) session.get(User.class, userId);
		
		return User;
	}	
	public User getUserByUsername(String username) {

		Session session = sessionFactory.getCurrentSession();
		//TypedQuery<User> query = session.createQuery("from User where username = ?");
		//query.setParameter(0, username);
		User User = (User) session.get(User.class, username);
		
		return User;
	}	
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User");
		List<User> UserList = query.list();

		return UserList;
	}
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<User> query = session.createQuery("from User");
		List<User> userList = query.getResultList();
		return userList;
	}
	public void addUser(User user) {

		Session session = sessionFactory.getCurrentSession();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		session.saveOrUpdate(user);
		session.flush();
	}	
	public void deleteUser(int id) {

		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from User where id = :id";
		Query query = session.createQuery(hql);	
		query.setParameter("id", id);
		query.executeUpdate();
	}
	public void updateUser(User user) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
		session.flush();

	}
}
