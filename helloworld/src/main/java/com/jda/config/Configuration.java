package com.jda.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.jda.dao.UserDao;
import com.jda.service.IuserService;
import com.jda.service.UserService;

@org.springframework.context.annotation.Configuration
@ComponentScan("com.jda.controller")
@EnableWebMvc
public class Configuration {
		@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/view/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}
	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource driverManagerDataSource= new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://"+ System.getenv("DBHOST") +"/"+ System.getenv("DBNAME"));
		driverManagerDataSource.setUsername(System.getenv("DBUSER"));
		driverManagerDataSource.setPassword(System.getenv("DBPASSWORD"));
		return driverManagerDataSource;
	}
	@Bean
	public UserService userService()
	{
		return new UserService();
	}
	@Bean
	public UserDao userDao()
	{
		return new UserDao();
	}
	@Bean
	public PasswordEncoder getPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}
}