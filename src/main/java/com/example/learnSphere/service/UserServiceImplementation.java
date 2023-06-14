package com.example.learnSphere.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.learnSphere.entity.Users;
import com.example.learnSphere.repository.UserRepository;
@Service
public class UserServiceImplementation implements UserService {
	@Autowired
	UserRepository repo;

	// for Adding users
	@Override
	public String addUser(Users user) {
		// TODO Auto-generated method stub
		repo.save(user);
		return "User added successfully";
	}
	
	
//for Checking Email
	@Override
	public boolean checkEmail(String email) {
		
		return repo.existsByEmail(email);
		 
	}

	
	// for validating users
	@Override
	public boolean validate(String email, String password,String role) {
		// TODO Auto-generated method stub
		if(repo.existsByEmail(email)) {
			Users u=repo.getByEmail(email);
			String dbPassword=u.getPassword();
			String dbRole = u.getRole();

			if(password.equals(dbPassword)&& role.equalsIgnoreCase(dbRole)) {
				return true;
			}
			else {
		return false;
	}
		}
		else {
			return false;
		}
	}


	@Override
	public String getUserRole(String email) {
		// TODO Auto-generated method stub
		Users user = repo.getByEmail(email);
	    if (user != null) {
	        return user.getRole();
	    }
		return "Please enter Email and password";
	}


	@Override
	public List<Users> findAllUsers() {
		 List<Users> users;
			List<Users> slist = repo.findAll();
		
			
		
	        return slist ;
	}


	private Object convertEntityToDto(Users user) {
		 Users userDto = new Users();
	        String[] name = user.getFirstName().split(" ");
	        userDto.setFirstName(name[0]);
	        userDto.setLastName(name[1]);
	        userDto.setEmail(user.getEmail());
	        return userDto;
	    }
	}


