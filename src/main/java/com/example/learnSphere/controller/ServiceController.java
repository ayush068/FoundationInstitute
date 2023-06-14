package com.example.learnSphere.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.learnSphere.entity.Users;
import com.example.learnSphere.service.UserService;

@Controller
public class ServiceController {
    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestParam("firstName") String firstName,
                          @RequestParam("lastName") String lastName,
                          @RequestParam("password") String password,
                          @RequestParam("email") String email,
                          @RequestParam("mobile") String mobile,
                          @RequestParam("role") String role ,Model model) {

        boolean emailExists = userService.checkEmail(email);
        if (!emailExists) {
            Users user = new Users();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPassword(password);
            user.setEmail(email);
            user.setMobile(mobile);
            user.setRole(role);

            userService.addUser(user);
           // model.addAttribute("successMessage", "User registered successfully");
            
            System.out.println("User registered successfully");
            return "redirect:/login";
            //return "redirect:/register?success";
        } else {
        	
            System.out.println("User already exists!");
            
            return "redirect:/register";
        }
    }
    @GetMapping("/users")
    public String listRegisteredUsers(Model model){
        List<Users> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
    @PostMapping("/validate")
    public String validate(@RequestParam("email") String email,
                           @RequestParam("password") String password) {
        String role = userService.getUserRole(email);

        if (email == null || email.isEmpty() && password == null || password.isEmpty()) {
            System.out.println("Unknown email or empty password!");
            return "/error";
        }

        boolean val = userService.validate(email, password, role);

        if (val) {
            if (role.equalsIgnoreCase("trainer")) {
                System.out.println("Trainer login successful!");
                return "trainerHome";
            } else if (role.equalsIgnoreCase("student")) {
                System.out.println("Student login successful!");
                return "studentHome";
            } else {
                System.out.println("Unknown role!");
                return "login";
            }
        } else {
            System.out.println("Incorrect credentials, try again!");
            return "login";
        }
    }
}
