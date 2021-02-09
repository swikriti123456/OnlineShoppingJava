package com.demo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;
import com.model.Product;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductService productservice = new ProductServiceImpl();
		List<Product> plist=null;
		try {
		if (request.getParameter("cid") == null) {
				plist=productservice.getAllProduct();
			
		} else {
			int id = Integer.parseInt(request.getParameter("cid"));
				plist = productservice.getProductById(id);
				
				
		}}catch(Exception e) {e.printStackTrace();}
			request.setAttribute("plist", plist);
			request.getRequestDispatcher("view/Product.jsp").forward(request, response);
		
	}
}
