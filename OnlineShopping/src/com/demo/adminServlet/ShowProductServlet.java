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

@WebServlet("/adminProduct")
public class ShowProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductService productservice = new ProductServiceImpl();

		try {
			request.setAttribute("clist", productservice.getCategory());
			request.setAttribute("plist", productservice.getAllProduct());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("view/adminProduct.jsp").forward(request, response);
	}

}
