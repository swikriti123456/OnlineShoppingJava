package com.demo.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.user;

public interface UserDao {

	boolean save(user u) throws SQLException;

	List<user> findAll() throws SQLException;

	user authentication(String email, String password) throws SQLException;

	user getByEmail(String email) throws SQLException;

	boolean update(user u) throws SQLException;

	user getById(int id) throws SQLException;

	boolean updateById(user u) throws SQLException;

}

