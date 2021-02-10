package com.demo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.category;

public class CategoryDaoImpl implements CategoryDao {

	
	private PreparedStatement pFindAll,pInsert;
	
	public CategoryDaoImpl() {
		try {
			pFindAll=DBUtil.getMyConnection().prepareStatement("select * from category");
			pInsert=DBUtil.getMyConnection().prepareStatement("insert into category(cName,imageUrl) value(?,?)");
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
	@Override
	public boolean save(category c) throws SQLException {
		pInsert.setString(1,c.getcName());
		pInsert.setString(2, c.getImage());
		
		int n=pInsert.executeUpdate();
		if(n>0) {
			return true;
		}
		return false;
	}

}
