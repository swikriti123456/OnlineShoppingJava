package com.demo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Product;

public class ProductDaoImpl implements ProductDao {

	private PreparedStatement pGetProductById,pGetAllProduct,pGetProduct,pInsert,pDelete;
	
	public ProductDaoImpl() {
		try {
			pGetProductById=DBUtil.getMyConnection().prepareStatement("select * from product where cid=?");
			pGetAllProduct=DBUtil.getMyConnection().prepareStatement("select * from product");
			pGetProduct=DBUtil.getMyConnection().prepareStatement("select * from product where pid=?");
			pInsert=DBUtil.getMyConnection().prepareStatement("insert into product(pid,pname,price,quantity,cid,brandName,subCategory,description,weight,imageUrl) value(?,?,?,?,?,?,?,?,?,?)");
			pDelete=DBUtil.getMyConnection().prepareStatement("delete from product where pid=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public List<Product> getProductBycId(int id) throws SQLException {
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
			Product p=new Product(rs.getInt("pid"),rs.getString("pname"),rs.getDouble("price"),rs.getInt("quantity"),rs.getString("imageUrl"),rs.getInt("cid"),rs.getString("brandName"),rs.getString("subCategory"),rs.getString("description"),rs.getString("weight"));
			plist.add(p);
		}
		return plist;
	}
	@Override
	public Product getProductBypId(int id) throws SQLException {
		pGetProduct.setInt(1, id);
		Product p=null;
		ResultSet rs=pGetProduct.executeQuery();
		if(rs.next()) {
			 p=new Product(rs.getInt("pid"),rs.getString("pname"),rs.getDouble("price"),rs.getInt("quantity"),rs.getString("imageUrl"),rs.getInt("cid"),rs.getString("brandName"),rs.getString("subCategory"),rs.getString("description"),rs.getString("weight"));
			
		}
		return p;
	}
	@Override
	public boolean save(Product p) throws SQLException {
		pInsert.setInt(1,p.getPid() );
		pInsert.setString(2, p.getpName());
		pInsert.setDouble(3, p.getPrice());
		pInsert.setInt(4, p.getQty());
		pInsert.setInt(5, p.getCid());
		pInsert.setString(6, p.getBrandName());
		pInsert.setString(7, p.getSubCategory());
		pInsert.setString(8, p.getDescription());
		pInsert.setString(9, p.getWeight());
		pInsert.setString(10, p.getImage());
		
		int n=pInsert.executeUpdate();
		if(n>0) {
			return true;
		}
		return false;
	}


	@Override
	public boolean deleteProductById(int pid) throws SQLException {
		pDelete.setInt(1, pid);
		int n=pDelete.executeUpdate();
		if(n>0) {
			return true;
		}
		return false;
	}
}
