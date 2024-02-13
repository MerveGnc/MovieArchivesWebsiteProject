

package com.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {

    
    @GetMapping("/login")
    public String loginPage() {
        return "login.html";
    }
    
    @GetMapping("/search")
    public String searchPage() {
        return "search.html";
    }
    
    @GetMapping("/signup")
    public String signupPage() {
        return "signup.html";
    }
    
    @GetMapping("/")
    public String HomePage() {
        return "home.html";
    }
    
    @GetMapping("/loginerror")
    public String ErrorPage() {
        return "loginerror.html";
    }
    
    @GetMapping("/save")
    public String SavePage() {
        return "addMovie.html";
    }
    
    @GetMapping("/save2")
    public String SavePage2() {
        return "addMovieAdmin.html";
    }
    
    @GetMapping("/added")
    public String AddedPage() {
        return "added.html";
    }
	
    @GetMapping("/all")
    public String AllPage() {
        return "allMovies.jsp";
    }
    
    @GetMapping("/adminlogin")
    public String AdminLoginPage() {
        return "adminLogin.html";
    }
    
    @GetMapping("/admindashboard")
    public String adPage() {
        return "adminDashboard.html";
    }
    
    @GetMapping("/guestPage")
    public String guestPage() {
        return "guestPage.html";
    }
    
    @GetMapping("/AUPage")
    public String AdminUserPage() {
        return "adminUserpage.html";
    }
    
    @GetMapping("/AULogin")
    public String AdminUserLogin() {
        return "adminUserLogin.html";
    }
  
	
}
