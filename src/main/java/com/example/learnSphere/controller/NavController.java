package com.example.learnSphere.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.learnSphere.entity.Users;

@Controller
public class NavController {

	
	@GetMapping("/")
	  public String index() {
	    return "index";
	}
	
	@GetMapping("/register")
	  public String register() {
	    return "register";
	}
	
	@GetMapping("/login")
	  public String login() {
	    return "login";
	}
	

	@GetMapping("/forgot")
	  public String forgot() {
	    return "forgot";
	}
	

	@GetMapping("/reset")
	  public String reset() {
	    return "reset";
	}
	
	@GetMapping("/service")
	  public String service() {
	    return "service";
	}
	
	@GetMapping("/home")
	  public String home() {
	    return "service";
	}
	
	@GetMapping("/error")
	  public String error() {
	    return "service";
	}
	
	@GetMapping("/createCourse")
	public String createCourse() {
		return "createCourse";
	}
	
	@GetMapping("/addLesson")
	public String addLesson() {
		return "addLesson";
	}
	
	@GetMapping("/TrainerHome")
	public String TrainerHome() {
		return "TrainerHome";
	}
	
	@GetMapping("/StudentHome")
	public String StudentHome() {
		return "StudentHome";
	}
	
	
	}
	
	
	
	
	

