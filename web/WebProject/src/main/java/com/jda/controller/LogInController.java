package com.jda.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class UserController
 */
@WebServlet("/user")
public class LogInController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String name = request.getParameter("name");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://"+System.getenv("DBHOST")+"/"+System.getenv("DBNAME")+"?user="+System.getenv("DBUSER")+"&password="+System.getenv("DBPASSWORD"));  
			  String username= request.getParameter("name").toString();
			String create="select * from db1000230.ServletUser where username) ";
			
			/*PreparedStatement pst = con.prepareStatement("select * from user where username = ? and password = ?");
			pst.setString(1, name);
			pst.setString(2, "qwerty");
			int status = pst.executeUpdate();
			*/
		} catch (SQLException | ClassNotFoundException e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
		
			dispatcher.forward(request, response);
		}
	}
}
