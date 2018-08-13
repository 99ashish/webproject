package com.jda.Validation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class filterData implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		final Pattern VALID_EMAIL_ADDRESS_REGEX = 
			    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		// TODO Auto-generated method stub
		String userName=request.getParameter("name");
		String email=request.getParameter("email");
		String dob=request.getParameter("dob");
		String password=request.getParameter("password");
		String path="error.jsp";
		System.out.println(password);
		if("".equals(userName)
				 ||"".equals(email)
						 || "".equals(request.getParameter("mobnum"))
						 || "".equals(dob)
						 || "".equals(password))
						 {
			RequestDispatcher rd= request.getRequestDispatcher("registration.jsp");
	        PrintWriter out=response.getWriter();
	        out.println("<font color=red> Please fill every field");
	        rd.include(request, response);
			
			
						 }
		long mob=Long.valueOf(request.getParameter("mobnum"));
		long lowerLimit=1111111111;
		
		if(lowerLimit>mob || mob<9*1111111111)
		{

        RequestDispatcher rd= request.getRequestDispatcher("registration.jsp");
        PrintWriter out=response.getWriter();
        out.println("<font color=red> Please Enter vaild Mobile Number");
        rd.include(request, response);
		}
		else if(!VALID_EMAIL_ADDRESS_REGEX.matcher(email).find())
		{
			RequestDispatcher rd= request.getRequestDispatcher("registration.jsp");
	        PrintWriter out=response.getWriter();
	        out.println("<font color=red> Please Enter vaild email id");
	        rd.include(request, response);
		}
		else if(password.length()>=10 &&password.length()<=5)
		{
			RequestDispatcher rd= request.getRequestDispatcher("registration.jsp");
	        PrintWriter out=response.getWriter();
	        out.println("<font color=red> Password length must should be between 5 to 10");
	        rd.include(request, response);
		}
		else
			chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
