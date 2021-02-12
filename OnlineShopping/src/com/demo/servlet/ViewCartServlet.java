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
import com.model.Item;
import com.model.Product;

@WebServlet("/viewCart")
public class ViewCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Item> ilist=new ArrayList<>();
		ProductService productservice=new ProductServiceImpl();
		HttpSession session=request.getSession();
		if(session.getAttribute("cart")== null) {
			response.sendRedirect("home");
		}
		else {
			HashMap<Integer,Integer> cart=(HashMap<Integer, Integer>) session.getAttribute("cart");
			for(Map.Entry<Integer, Integer> it:cart.entrySet()) {
				try {
					Product p=productservice.getProductBypId(it.getKey());
					ilist.add(new Item(p.getPid(),it.getValue(),p.getpName(),p.getPrice(),p.getImage()));
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			request.setAttribute("ilist",ilist );
		request.getRequestDispatcher("view/ViewCart.jsp").forward(request, response);
		}
		
	}


}
