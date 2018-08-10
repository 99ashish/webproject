package com.jda.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jda.Model.UserModel;
import com.jda.dao.Dbo;
/**
 * Servlet implementation class UserController
 */
public class LogInController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		PrintWriter out = response.getWriter();
		
		try {
			UserModel userModel=null;
			ResultSet res=Dbo.checkUserDetail(email,userModel);
			int cnt=0;
			while(res.next())
			{
				userModel=new UserModel();
				 userModel.setName(res.getString(1));
				 userModel.setPassword(res.getString(5));
				cnt++;
			}
			if(cnt==1)
			{
				if(userModel.getPassword().equals(password))
				{
				request.getSession().setAttribute("user", userModel);
				RequestDispatcher dispatcher = request.getRequestDispatcher(response.encodeRedirectURL("home.jsp"));
				dispatcher.forward(request, response);
				}
				else
				{
					response.sendRedirect("login.jsp");
				}
			}
			else
			{
				response.sendRedirect("login.jsp");
			}
		} catch (SQLException | ClassNotFoundException e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(response.encodeRedirectURL("login.jsp"));
			dispatcher.forward(request, response);
		}
	}
}
