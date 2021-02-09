package com.demo.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;
import com.model.Product;

@WebServlet("/productDetails")
public class ProductDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService productservice=new ProductServiceImpl();
		Product p=null;
		if (request.getParameter("pid") == null) {
			response.sendRedirect("product");
		} else {
			int id = Integer.parseInt(request.getParameter("pid"));
			try {
				p = productservice.getProduct(id);
				
				request.setAttribute("product", p);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("view/productDetails.jsp").forward(request, response);
		}
	}

	

}
