package com.demo.adminServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.service.CategoryService;
import com.demo.service.CategoryServiceImpl;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

@WebServlet("/deleteCategory")
public class DeleteCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int cid=Integer.parseInt(request.getParameter("cid"));
		
		CategoryService productservice=new CategoryServiceImpl();
		
		try {
			boolean flag=productservice.deleteCategoryById(cid);
			if(flag)
				request.setAttribute("successMsg", "deleted successfully");
		} catch (SQLException e) {
		
			request.setAttribute("errorMsg", "invalid id");
		}
		response.sendRedirect("adminCategory");
	}

	
}
