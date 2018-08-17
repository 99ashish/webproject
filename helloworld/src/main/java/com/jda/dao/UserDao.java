package com.jda.dao;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jda.model.UserModel;

@Repository
public class UserDao implements IUserDao
{
	@Autowired
	DataSource dataSource;
	public int registerUser(UserModel userData) {
		int id=0;
		try{
            Connection con= dataSource.getConnection();
            String query="insert into userdetail value(?,?,?,?,?)";
            Object args[]=new Object[]{userData.getName(),userData.getDob(),userData.getPhoneNumber()
                                           ,userData.getEmail(),userData.getPassword()};
            JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);
            id= jdbcTemplate.update(query, args);
           return id;
		}
		catch(Exception e)
		{
			return id;
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public UserModel logIn(UserModel userData) {
		try{
		Connection con= dataSource.getConnection();
		String query="select * from userdetail where email=?";
		Object[] args=new Object[]{userData.getEmail()};
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		List<UserModel> userdetail= jdbcTemplate.query(query, args, new RowMapper<UserModel>(){
			
			public UserModel mapRow(ResultSet resultSet,int rowNum)
			{
				UserModel userDetail=null;
				try{
					userDetail=new UserModel();
					userDetail.setName(resultSet.getString("name"));
					userDetail.setDob(resultSet.getString("dob"));
					userDetail.setPassword(resultSet.getString("password"));
				return userDetail;
				}
				catch(Exception e)
				{
					return userDetail;
				}
			}
		});
		return userdetail.get(0);
		}
		catch(Exception e){
			
		}
		return null;
	}
}