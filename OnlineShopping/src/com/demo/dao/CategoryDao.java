package com.demo.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.category;

public interface CategoryDao {

	List<category> getAllCategory() throws SQLException;

}
