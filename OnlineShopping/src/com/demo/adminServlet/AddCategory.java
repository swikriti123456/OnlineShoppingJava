package com.demo.adminServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;
import com.model.category;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

@WebServlet("/addCategory")
public class AddCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("view/adminCategory.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pName = request.getParameter("inputname");
		String image = request.getParameter("inputImage");
		
		ProductService productservice=new ProductServiceImpl();
		
		try {
			boolean flag=productservice.save(new category(pName,image));
			 if(flag) {
				request.getSession().setAttribute("successMsg","inserted successfully");
				
			}
		
		} catch (SQLException e) {
			request.getSession().setAttribute("warningMsg", e.getMessage());
		}
		
		response.sendRedirect("adminCategory");
	}

}
