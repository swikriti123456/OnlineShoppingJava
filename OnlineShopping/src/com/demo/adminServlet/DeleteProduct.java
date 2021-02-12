package com.demo.adminServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

@WebServlet("/deleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int pid=Integer.parseInt(request.getParameter("pid"));
		
		ProductService productservice=new ProductServiceImpl();
		
		try {
			boolean flag=productservice.deleteProductById(pid);
			if(flag)
				request.setAttribute("successMsg", "deleted successfully");
		} catch (SQLException e) {
		
			request.setAttribute("errorMsg", "invalid id");
		}
		response.sendRedirect("adminProduct");
	}

	
}
