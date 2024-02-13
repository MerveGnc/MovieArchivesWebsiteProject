package com.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.finalproject.model.User;
import com.finalproject.service.UserService;

@Controller
public class UserController {
	 @Autowired
	    private UserService userService;
	    
	    @PostMapping("/signup")
	    public String registerUser(@ModelAttribute("user") User user) {
	       
	        User savedUser = userService.registerUser(user);
	        System.out.println("Saved user: " + savedUser);
	        
	        return "redirect:/login";
	    } 
	       
	    
	    @PostMapping("/login")
	    public String loginUser(@RequestParam("username") String username, @RequestParam("password") String password) {
	       
	        if (userService.authenticateUser(username, password)) {
	        
	            return "redirect:/search";
	            
	        } else {
	            return "redirect:/loginerror";
	        }
	    }

	    
	   


	
	

}
