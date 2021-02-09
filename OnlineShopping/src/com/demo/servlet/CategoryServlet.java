package com.demo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;
import com.model.category;

@WebServlet("/category")
public class CategoryServlet extends HttpServlet
{
	ProductService productservice=new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			List<category> clist =productservice.getCategory();
			
			req.setAttribute("clist", clist);
			req.getRequestDispatcher("view/Category.jsp").forward(req, resp);
		} catch (SQLException e) {
			req.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		
		//resp.sendRedirect("view/Category.jsp");
	}
}
