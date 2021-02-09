package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.service.UserService;
import com.demo.service.UserServiceImpl;
import com.model.user;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		request.getRequestDispatcher("view/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserService userservice = new UserServiceImpl();
	
		String Msg;
		try {
			user u = userservice.validate(email, password);
			
			if (u != null) {
				HttpSession session=request.getSession();
				session.setAttribute("user", u);
				if(u.getRole().equals("admin"))
					response.sendRedirect("adminHome");
				else
				response.sendRedirect("home");
			} else {
				
				request.getSession().setAttribute("errorMsg", "invalid user");
				request.getRequestDispatcher("view/login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			Msg="error";
			e.printStackTrace();
		}

	}

}
