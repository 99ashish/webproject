package com.jda.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jda.model.UserModel;
import com.jda.service.IuserService;
import com.jda.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private IuserService userService;

	String message="World";
	
	@RequestMapping(value="/")
	public ModelAndView getView(){
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/hello")
	public ModelAndView startupPage(){
		ModelAndView model = new ModelAndView("home");
		model.addObject("message", message);
		return model;
	}
	
	@RequestMapping( value = "/registerform" )
	public ModelAndView regPage(){
		ModelAndView model = new ModelAndView("registration");
		return model;
	}
	@RequestMapping( value = "/register"  )
	public ModelAndView registerData( @ModelAttribute("userDetail")UserModel userDetails){
		if(userService.registerUser(userDetails))
		{
			ModelAndView model = new ModelAndView("index");
			return model;
		}
		else
		{
		System.out.println(userDetails.getName());
		ModelAndView model = new ModelAndView("sample");
		model.addObject("name", userDetails.getName());
		return model;
		}
	}
	@RequestMapping( value = "/loginform" )
	public ModelAndView logInPage(){
		ModelAndView model = new ModelAndView("login");
		return model;
	}
	@RequestMapping(value = "/login")
	public ModelAndView logIn(@ModelAttribute("credential")UserModel userDetails, HttpSession httpSession){
		UserModel userModel = userService.logIn(userDetails);
		if(userModel!= null)
		{
		ModelAndView model = new ModelAndView("home");
		httpSession.setAttribute("user", userModel);
		//model.addObject("name",userDetails.getName());
		return model;
	}
		else
		{
			ModelAndView model = new ModelAndView("error");
			return model;
		}
	}
	@RequestMapping(value = "/forgot")
	public ModelAndView forgotPage(){
		ModelAndView model = new ModelAndView("forgotpassword");
		return model;
	}
	
}