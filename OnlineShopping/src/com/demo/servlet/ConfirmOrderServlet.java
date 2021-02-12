package com.demo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;
import com.model.Product;


/**
 * Servlet implementation class ConfirmOrderServlet
 */
@WebServlet("/confirmOrder")
public class ConfirmOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		HashMap<Integer,Integer> hm= (HashMap<Integer, Integer>) session.getAttribute("cart");
		List<Product> plist=new ArrayList();
		ProductService productService=new ProductServiceImpl();
		for(Map.Entry<Integer, Integer>entry:hm.entrySet()) {
			Product p;
			try {
				p =  productService.getProductBypId(entry.getKey());
				p.setQty(entry.getValue());
				plist.add(p);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		request.setAttribute("list", plist);
		request.getRequestDispatcher("view/placeOrder.jsp").forward(request, response);
	}

}
