package com.demo.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.category;

public interface CategoryDao {

	List<category> getAllCategory() throws SQLException;

	boolean save(category category) throws SQLException;

	boolean deleteCategoryById(int cid) throws SQLException;

}
