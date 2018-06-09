package kr.ac.hansung.cse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.cse.dao.UserDao;
import kr.ac.hansung.cse.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public List<User> getUsers(){
		return userDao.getUsers();
	}
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}
	
	public void adduser(User user) {
		userDao.addUser(user);
	}
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}
	public void updateUser(User user) {
		userDao.updateUser(user);
	}
}


