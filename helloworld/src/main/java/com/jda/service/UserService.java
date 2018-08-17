package com.jda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.jda.dao.IUserDao;
import com.jda.model.UserModel;

@Service
public class UserService implements IuserService {
	
	@Autowired
	IUserDao userDao;
	
	@Autowired
	PasswordEncoder passEncoder;

	public boolean registerUser(UserModel userData) {
		userData.setPassword(passEncoder.encode(userData.getPassword()));
		if (userDao.registerUser(userData) > 0)
			return true;
		return false;
	}

	public UserModel logIn(UserModel userData) {
		UserModel logIndetail=userDao.logIn(userData);
		if( logIndetail!= null)
		{
			System.out.println();
			if(BCrypt.checkpw(userData.getPassword(), logIndetail.getPassword())){
				logIndetail.setPassword(null);
				return logIndetail;
			}
			return null;
		}
		return null;
	}
}