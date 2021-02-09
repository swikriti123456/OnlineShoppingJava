package com.demo.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("pid") != null && request.getParameter("qty") != null){
			HttpSession session=request.getSession();
			HashMap<Integer,Integer> cart=null;
			if(session.getAttribute("cart")==null) {
				cart=new HashMap<>();
			}
				else {
					cart =(HashMap<Integer, Integer>) session.getAttribute("cart");
					
				}
			cart.put(Integer.parseInt(request.getParameter("pid")),Integer.parseInt(request.getParameter("qty")));
			session.setAttribute("cart", cart);
			}
		response.sendRedirect("product");
		}
		
	}

	


