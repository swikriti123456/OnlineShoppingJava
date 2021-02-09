package com.demo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.category;

public class CategoryDaoImpl implements CategoryDao {

	
	private PreparedStatement pFindAll;
	
	public CategoryDaoImpl() {
		try {
			pFindAll=DBUtil.getMyConnection().prepareStatement("select * from category");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	@Override
	public List<category> getAllCategory() throws SQLException {
		List<category> clist= new ArrayList<>();
		ResultSet rs=pFindAll.executeQuery();
		while(rs.next()) {
			category c=new category(rs.getInt(1),rs.getString(2),rs.getString(3));
			clist.add(c);
			
		}
		return clist;
	}

}
