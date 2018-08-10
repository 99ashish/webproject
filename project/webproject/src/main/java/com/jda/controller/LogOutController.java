package com.jda.controller;

import java.awt.SecondaryLoop;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jda.dao.Dbo;
import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

public class LogOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		session.invalidate();
		session.removeAttribute("user");
		response.sendRedirect("login.jsp");
		// RequestDispatcher
		// requestDispatcher=request.getRequestDispatcher("login.jsp");
	}
}