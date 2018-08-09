package com.jda.controller;

import java.sql.Date;

public class UserModel {
String name;
String contactNumber;
String password;
String DOB;
String emailId;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getContactNumber() {
	return contactNumber;
}
public void setContactNumber(String contactNumber) {
	this.contactNumber = contactNumber;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getDOB() {
	return DOB;
}
public void setDOB(String string) {
	DOB = string;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
}
