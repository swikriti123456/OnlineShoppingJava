package com.demo.service;

import java.sql.SQLException;

import com.model.User;

public interface UserService {

	User validate(String email, String password) throws SQLException;

	boolean save(User user) throws SQLException;

	User getUser(User user) throws SQLException;

}
