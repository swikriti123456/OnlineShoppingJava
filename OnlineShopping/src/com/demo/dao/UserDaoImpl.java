package com.demo.dao;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.User;




public class UserDaoImpl implements UserDao{

	private PreparedStatement psInsert;
	private PreparedStatement psFindAll;
	private PreparedStatement psAuth;
	private PreparedStatement psFindByEmail;
	private PreparedStatement psUpdate;
	private PreparedStatement psFindById;
	private PreparedStatement psUpdateById;
	public UserDaoImpl()  {
		try {
			psInsert=DBUtil.getMyConnection().prepareStatement("insert into users(firstName,lastName,email,address,mobileNo,password,role) value(?,?,?,?,?,?,?)");
			psFindAll=DBUtil.getMyConnection().prepareStatement("select * from users");
			psAuth=DBUtil.getMyConnection().prepareStatement("select * from users where email=? and password=?");
			psFindByEmail=DBUtil.getMyConnection().prepareStatement("select * from users where email=?");
			psUpdate=DBUtil.getMyConnection().prepareStatement("update users set firstName=?,lastName=?,address=?, mobileNo=? where email=?");
			psUpdateById=DBUtil.getMyConnection().prepareStatement("update users set firstName=?,lastName=?,address=?, mobileNo=? where uid=?");
			psFindById=DBUtil.getMyConnection().prepareStatement("select * from users where uid=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public boolean save(User u) throws SQLException {
	
		psInsert.setString(1, u.getFirstName());
		psInsert.setString(2, u.getLastName());
		psInsert.setString(3, u.getEmail());
		psInsert.setString(4, u.getAddress());
		psInsert.setString(5, u.getMobileNumber());
		psInsert.setString(6, u.getPassword());
		psInsert.setString(7, u.getRole());
		
		int n=psInsert.executeUpdate();
		System.out.println("njhikk:- "+n);
		if(n>0) {
			return true;
		}
		return false;
	}
	@Override
	public List<User> findAll() throws SQLException {
		List<User> ulist=new ArrayList<>();
		ResultSet rs=psFindAll.executeQuery();
		while(rs.next()) {
			User u=new User();
			ulist.add(u);
		}
		return ulist;
	}
	@Override
	public User authentication(String email, String password) throws SQLException {
	
		psAuth.setString(1, email);
		psAuth.setString(2, password);
		
		
		ResultSet rs=psAuth.executeQuery();
		while(rs.next()) {
			if(rs.getString("email").equals(email) && rs.getString("password").equals(password)) {
				return new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
			}
		}
		return null;
	}
	@Override
	public User getUser(User user) throws SQLException {
		psFindByEmail.setString(1, user.getEmail());
		ResultSet rs=psFindByEmail.executeQuery();
		if(rs.next()) {
			return new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
		}
		return null;
	}
	@Override
	public boolean update(User u) throws SQLException {
		psUpdate.setString(1, u.getFirstName());
		psUpdate.setString(2, u.getLastName());
		psUpdate.setString(3,u.getAddress());
		psUpdate.setString(4, u.getMobileNumber());
		psUpdate.setString(5, u.getEmail());
		int rows=psUpdate.executeUpdate();
		if(rows>0)
			return true;
		return false;
	}
	@Override
	public boolean updateById(User u) throws SQLException {
		psUpdateById.setString(1, u.getFirstName());
		psUpdateById.setString(2, u.getLastName());
		psUpdateById.setString(3,u.getAddress());
		psUpdateById.setString(4, u.getMobileNumber());
		psUpdateById.setInt(5, u.getUid());
		int rows=psUpdateById.executeUpdate();
		if(rows>0)
			return true;
		return false;
	}

	@Override
	public User getById(int id) throws SQLException {
		psFindById.setInt(1,id);
		
		ResultSet rs=psFindById.executeQuery();
		if(rs.next()) {
			return new User();
		}
		return null;
	}
	
}
