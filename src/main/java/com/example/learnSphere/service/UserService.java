package com.example.learnSphere.service;

import java.util.List;

//import com.example.learnSphere.controller.UserDto;
import com.example.learnSphere.entity.Users;

public interface UserService  {
	
	//adds new users to database
  String addUser(Users user);
  
  // checks email is already present in database or not
  



boolean checkEmail(String email);


//validate users credentials
boolean validate(String email, String password,String role);

String getUserRole(String email);

List<Users> findAllUsers();







}


