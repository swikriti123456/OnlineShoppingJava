package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.User;


@WebServlet("/verifyCode")
public class VerifyCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		User u=(User) session.getAttribute("authcode");
		
		PrintWriter out=response.getWriter();
		
		String code=request.getParameter("authcode");
		if(code.equals(u.getCode())) {
			out.print("varification done");
			response.sendRedirect("login");
		}
		else {
			out.print("incorrect verificationcode");
			request.getRequestDispatcher("view/verify.jsp").forward(request, response);
		}
	}

}
