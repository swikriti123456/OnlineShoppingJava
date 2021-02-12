package com.demo.service;

import java.sql.SQLException;
import java.util.List;

import com.demo.dao.CategoryDao;
import com.demo.dao.CategoryDaoImpl;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;
import com.model.Product;
import com.model.category;

public class ProductServiceImpl implements ProductService {

	
	ProductDao productdao=new ProductDaoImpl();
	
	@Override
	public List<Product> getProductBycId(int id) throws SQLException {
		return productdao.getProductBycId(id);
	}
	@Override
	public List<Product> getAllProduct() throws SQLException {
		return productdao.getAllProduct();
	}
	@Override
	public Product getProductBypId(int id) throws SQLException {
		return productdao.getProductBypId(id);
	}
	@Override
	public boolean save(Product product) throws SQLException {
	
		return productdao.save(product);
	}
	@Override
	public boolean deleteProductById(int pid) throws SQLException {
		
		return productdao.deleteProductById(pid);
	}
	
}
