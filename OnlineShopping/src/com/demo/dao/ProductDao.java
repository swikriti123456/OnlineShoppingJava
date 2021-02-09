package com.demo.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Product;
import com.model.category;

public interface ProductDao {

	List<Product> getProductById(int id) throws SQLException;

	List<Product> getAllProduct() throws SQLException;

	Product getProduct(int id) throws SQLException;

	boolean save(Product p) throws SQLException;



}
