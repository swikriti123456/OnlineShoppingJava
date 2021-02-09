package com.demo.service;

import java.sql.SQLException;
import java.util.List;

import com.model.Product;
import com.model.category;

public interface ProductService {

	List<category> getCategory() throws SQLException;

	

	List<Product> getProductById(int id) throws SQLException;



	List<Product> getAllProduct() throws SQLException;



	Product getProduct(int id) throws SQLException;



	boolean save(Product product) throws SQLException;



	boolean save(category category) throws SQLException;

}
