package com.jda.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class Dbo {
	private static Connection con=null;
	static Scanner sc=new Scanner(System.in);
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");  
		 con=DriverManager.getConnection(  
				"jdbc:mysql://"+System.getenv("DBHOST")+"/"+System.getenv("DBNAME")+"?user="+System.getenv("DBUSER")+"&password="+System.getenv("DBPASSWORD"));  
		return con;
	}	
 public static void insertIntoDb(com.jda.Model.UserModel userDetail) throws SQLException, ClassNotFoundException
 {
	 PreparedStatement pst = getConnection().prepareStatement("insert into db1000230.userdetail values(?,?,?,?,?)");
	 pst.setString(1, userDetail.getName());
	 pst.setString(2, userDetail.getDob());
	 pst.setString(3, userDetail.getContactno());
	 pst.setString(4, userDetail.getEmail());
	 pst.setString(5, userDetail.getPassword());
	 pst.executeUpdate();
 }
 public static void closeConnection(Connection con) throws SQLException
 {
	 con.close();
 }
 public static ResultSet checkUserDetail(String email,com.jda.Model.UserModel userData) throws SQLException, ClassNotFoundException
 {
	 PreparedStatement pst = getConnection().prepareStatement("select * from db1000230.userdetail where  email =?");
	 pst.setString(1, email);
	 ResultSet res=pst.executeQuery();
	 return res;
 } 
}
