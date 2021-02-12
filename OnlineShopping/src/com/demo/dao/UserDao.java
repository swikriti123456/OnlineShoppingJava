package com.demo.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.User;


public interface UserDao {

	boolean save(User u) throws SQLException;

	List<User> findAll() throws SQLException;

	User authentication(String email, String password) throws SQLException;

	User getByEmail(String email) throws SQLException;

	boolean update(User u) throws SQLException;

	User getById(int id) throws SQLException;

	boolean updateById(User u) throws SQLException;

}

