package com.jda.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class db {
	static Connection con=null;
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");  
		 con=DriverManager.getConnection(  
				"jdbc:mysql://"+System.getenv("DBHOST")+"/"+System.getenv("DBNAME")+"?user="+System.getenv("DBUSER")+"&password="+System.getenv("DBPASSWORD"));  
		return con;
	}
 public static void insertIntoDb() throws SQLException
 {
	 PreparedStatement pst = con.prepareStatement("select * from user where username = ? and password = ?");
 }
 public static void checkUserDetail(String user,String pass)
 {
	 String statement="select * from db1000230.ServletUser where  "+user.equals(username) +pass.equals(password);
 }
}
