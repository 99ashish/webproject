package com.jda.dao;

import com.jda.model.UserModel;

public interface IUserDao{
	public int registerUser(UserModel userData);
	public UserModel logIn(UserModel userData);
}
