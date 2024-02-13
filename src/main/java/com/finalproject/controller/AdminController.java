package com.finalproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.finalproject.service.AdminService;
import com.finalproject.service.UserService;
import com.finalproject.model.User;

@Controller
//@RequestMapping("/admin")
public class AdminController {

	@Autowired
    private AdminService adminService;


	@PostMapping("/adminlogin")
	public String adminLogin(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
	    boolean isAdmin = adminService.isAdmin(username, password);
	    if (isAdmin) {
	        // Admin girişi başarılı
	        return "redirect:/admindashboard"; 
	    } else {
	        // Admin girişi başarısız
	        model.addAttribute("error", "Invalid username or password");
	        return "redirect:/adminlogin"; 
	    }
	}
	
	@Autowired
    private UserService userService;

    @GetMapping("/usercontrol2")
    public String dashboard2(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admininfouser.jsp";
    }
    
    @GetMapping("/usercontrol")
    public String dashboard(Model model) {
        List<User> users = userService.getAllUsers();
        List<User> adminUsers = new ArrayList<>();
        List<User> nonAdminUsers = new ArrayList<>();

        for (User user : users) {
            if (user.isAdmin()) {
                adminUsers.add(user);
            } else {
                nonAdminUsers.add(user);
            }
        }

        model.addAttribute("adminUsers", adminUsers);
        model.addAttribute("nonAdminUsers", nonAdminUsers);

        return "adminControlUser.jsp";
    }
    @PostMapping("/makeAdmin")
    public String makeAdmin(@RequestParam("userId") Long userId) {
        User user = userService.getUserById(userId);
        user.setAdmin(true);
        userService.saveUser(user);
        return "redirect:/usercontrol";
    }

    @PostMapping("/makeNonAdmin")
    public String makeNonAdmin(@RequestParam("userId") Long userId) {
        User user = userService.getUserById(userId);
        user.setAdmin(false);
        userService.saveUser(user);
        return "redirect:/usercontrol";
    }
    
    @PostMapping("/login2")
    public String loginUser2(@RequestParam("username") String username, @RequestParam("password") String password) {
       
        if (userService.authenticateUser(username, password)) {
            User user = userService.getUserByUsername(username);
            if (user.isAdmin()) {
               
                return "redirect:/AUPage";
            }
            return "redirect:/login";
            
        } else {
            return "redirect:/loginerror";
        }
    }

	


}
