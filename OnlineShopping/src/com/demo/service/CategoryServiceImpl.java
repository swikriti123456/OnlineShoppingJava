package com.demo.service;

import java.sql.SQLException;
import java.util.List;

import com.demo.dao.CategoryDao;
import com.demo.dao.CategoryDaoImpl;
import com.model.category;

public class CategoryServiceImpl implements CategoryService
{
	CategoryDao categorydao=new CategoryDaoImpl();
	@Override
	public List<category> getCategory() throws SQLException {
		
		return categorydao.getAllCategory() ;
	}
	@Override
	public boolean save(category category) throws SQLException {
		return categorydao.save(category);
	}
	@Override
	public boolean deleteCategoryById(int cid) throws SQLException {
		
		return categorydao.deleteCategoryById(cid);
	}
}
