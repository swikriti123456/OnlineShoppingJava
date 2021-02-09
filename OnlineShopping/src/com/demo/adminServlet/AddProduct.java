package com.demo.adminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;
import com.model.Product;


@WebServlet("/addProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pName=request.getParameter("inputname");
		double price=Double.parseDouble(request.getParameter("inputPrice"));
		int qty=Integer.parseInt(request.getParameter("inputQuantity")); 
		int cid=Integer.parseInt(request.getParameter("cid"));
		String brandName=request.getParameter("inputBrandName");
		String subCategory=request.getParameter("inputSubCateg");
		String description=request.getParameter("inputDesc");
		String image=request.getParameter("inputImage");
		String weight=request.getParameter("inputWeight");
		
		ProductService productservice=new ProductServiceImpl();
		PrintWriter out=response.getWriter();
		try {
			boolean flag=productservice.save(new Product(pName,price,qty,cid,brandName,subCategory,description,image,weight));
			if(flag) {
				request.getSession().setAttribute("successMsg","inserted successfully");
				
			}
		
		} catch (SQLException e) {
			request.getSession().setAttribute("warningMsg", e.getMessage());
			
		}
		response.sendRedirect("adminProduct");
	}

}
