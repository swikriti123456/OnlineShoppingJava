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

@WebServlet("/adminCategory")
public class ShowCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,  IOException {
		CategoryService categoryservice=new CategoryServiceImpl();

			try {
				request.setAttribute("clist", categoryservice.getCategory());
				

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("view/adminCategory.jsp").forward(request, response);
		}
	}

	


