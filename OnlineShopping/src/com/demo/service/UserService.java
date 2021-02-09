package com.demo.service;

import java.sql.SQLException;

import com.model.user;

public interface UserService {

	user validate(String email, String password) throws SQLException;

	boolean save(user user) throws SQLException;

}
