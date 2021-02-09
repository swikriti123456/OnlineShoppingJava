package com.demo.service;

import java.sql.SQLException;

import com.demo.dao.UserDao;
import com.demo.dao.UserDaoImpl;
import com.model.user;

public class UserServiceImpl implements UserService {
UserDao userdao=new UserDaoImpl();
	@Override
	public user validate(String email, String password) throws SQLException {
	
		return userdao.authentication(email, password);
	}
	@Override
	public boolean save(user user) throws SQLException {
	
		return userdao.save(user);
	}

}
