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



import com.demo.service.SendEmail;
import com.demo.service.UserService;
import com.demo.service.UserServiceImpl;
import com.model.User;

@WebServlet("/registeration2")
public class RegistrationServlet2 extends HttpServlet {
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
		
		String role="user";
		UserService userservice=new UserServiceImpl();
		
		
		try {
				User user=new User(email);
				
				SendEmail sm=new SendEmail();
				
				String code=sm.getRandom();
				System.out.println("code:- "+code);
				user.setCode(code);
				
				boolean flag1=sm.sendEmail(user);
				
				if(flag1) {
					user=new User(firstName,lastName,email,address,mobileNumber,password,role);
					userservice.save(user);
					HttpSession session=request.getSession();
					session.setAttribute("authcode", user);
					resp.sendRedirect("verifyCode");
				
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
