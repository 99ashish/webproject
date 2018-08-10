package com.jda.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jda.Model.UserModel;
import com.jda.dao.Dbo;

public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        UserModel userData=new UserModel();
       PrintWriter out = response.getWriter();
		try {
			System.out.println(request.getParameter("dob"));
			userData.setName(request.getParameter("name"));
		       userData.setDob(request.getParameter("dob"));
		       userData.setEmail(request.getParameter("email"));
		       userData.setContactno(request.getParameter("mobnum"));
		       userData.setPassword(request.getParameter("password"));
				
		Dbo.insertIntoDb(userData);
		RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
		} catch (SQLException | ClassNotFoundException e) {
			//RequestDispatcher dispatcher = request.getRequestDispatcher(response.encodeRedirectURL("registration.jsp"));
			//dispatcher.forward(request, response);
		}
	}
}
