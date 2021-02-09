package com.demo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Product;

public class ProductDaoImpl implements ProductDao {

	private PreparedStatement pGetProductById,pGetAllProduct,pGetProduct;
	
	public ProductDaoImpl() {
		try {
			pGetProductById=DBUtil.getMyConnection().prepareStatement("select * from product where cid=?");
			pGetAllProduct=DBUtil.getMyConnection().prepareStatement("select * from product");
			pGetProduct=DBUtil.getMyConnection().prepareStatement("select * from product where pid=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<Product> getProductById(int id) throws SQLException {
		List<Product> plist =new ArrayList<>();
		pGetProductById.setInt(1,id);
		
		ResultSet rs=pGetProductById.executeQuery();
		while(rs.next()) {
			Product p=new Product(rs.getInt("pid"),rs.getString("pname"),rs.getDouble("price"),rs.getInt("quantity"),rs.getString("imageUrl"),rs.getInt("cid"));
			plist.add(p);
		}
		return plist;
	}
	@Override
	public List<Product> getAllProduct() throws SQLException {
		List<Product> plist =new ArrayList<>();
				
		ResultSet rs=pGetAllProduct.executeQuery();
		while(rs.next()) {
			Product p=new Product(rs.getInt("pid"),rs.getString("pname"),rs.getDouble("price"),rs.getInt("quantity"),rs.getString("imageUrl"),rs.getInt("cid"));
			plist.add(p);
		}
		return plist;
	}
	@Override
	public Product getProduct(int id) throws SQLException {
		pGetProduct.setInt(1, id);
		Product p=null;
		ResultSet rs=pGetProduct.executeQuery();
		if(rs.next()) {
			 p=new Product(rs.getInt("pid"),rs.getString("pname"),rs.getDouble("price"),rs.getInt("quantity"),rs.getString("imageUrl"),rs.getInt("cid"),rs.getString("brandName"),rs.getString("subCategory"),rs.getString("description"),rs.getString("weight"));
			
		}
		return p;
	}
}
