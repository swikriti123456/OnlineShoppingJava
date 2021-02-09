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

	CategoryDao categorydao=new CategoryDaoImpl();
	ProductDao productdao=new ProductDaoImpl();
	@Override
	public List<category> getCategory() throws SQLException {
		
		return categorydao.getAllCategory() ;
	}
	@Override
	public List<Product> getProductById(int id) throws SQLException {
		return productdao.getProductById(id);
	}
	@Override
	public List<Product> getAllProduct() throws SQLException {
		return productdao.getAllProduct();
	}
	@Override
	public Product getProduct(int id) throws SQLException {
		return productdao.getProduct(id);
	}
}
