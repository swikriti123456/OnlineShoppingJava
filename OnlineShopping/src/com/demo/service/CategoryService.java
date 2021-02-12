package com.demo.service;

import java.sql.SQLException;
import java.util.List;

import com.model.category;

public interface CategoryService {
	List<category> getCategory() throws SQLException;
	boolean save(category category) throws SQLException;
	boolean deleteCategoryById(int cid) throws SQLException;

}
