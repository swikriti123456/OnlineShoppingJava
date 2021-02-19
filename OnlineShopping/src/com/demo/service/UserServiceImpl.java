package com.demo.service;

import java.sql.SQLException;

import com.demo.dao.UserDao;
import com.demo.dao.UserDaoImpl;
import com.model.User;


public class UserServiceImpl implements UserService {
UserDao userdao=new UserDaoImpl();
	@Override
	public User validate(String email, String password) throws SQLException {
	
		return userdao.authentication(email, password);
	}
	@Override
	public boolean save(User user) throws SQLException {
	
		return userdao.save(user);
	}
	@Override
	public User getUser(User user) throws SQLException {
		return userdao.getUser(user);
	}

}
