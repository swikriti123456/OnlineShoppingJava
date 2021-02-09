package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.User;

import com.demo.service.UserService;
import com.demo.service.UserServiceImpl;
import com.model.user;

@WebServlet("/registeration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("view/registration.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		String firstName=request.getParameter("fName");
		String lastName=request.getParameter("lName");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String mobileNumber=request.getParameter("mob");
		String password=request.getParameter("password");
		
		String role=request.getParameter("role");
		UserService userservice=new UserServiceImpl();
		System.out.println("fnvknknlkfgmblkfnb");
		try {
			boolean flag=userservice.save(new user(firstName,lastName,email,address,mobileNumber,password,role));
			System.out.println("flag :- "+flag);
			if(flag) {
				resp.sendRedirect("login");
			}
			else {
				request.getRequestDispatcher("view/registration.jsp").forward(request, resp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
