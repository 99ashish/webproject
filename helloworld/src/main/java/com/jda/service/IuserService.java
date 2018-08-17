package com.jda.service;

import com.jda.model.UserModel;

public interface IuserService{
	public boolean registerUser(UserModel userDetails);
	public UserModel logIn(UserModel userData);
	
}