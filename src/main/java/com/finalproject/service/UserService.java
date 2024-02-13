package com.finalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.finalproject.model.User;
import com.finalproject.repository.UserRepository;

@Service
public class UserService {
	
	  @Autowired
	    private UserRepository userRepository;

	    public User getUserByUsername(String username) {
	        return userRepository.findByUsername(username);
	    }

	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }

	    public void grantAdminRole(Long userId) {
	        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Kullanıcı bulunamadı: " + userId));
	        user.setAdmin(true);
	        userRepository.save(user);
	    }
	    
	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    
	    public User registerUser(User user) {
	        String encodedPassword = passwordEncoder.encode(user.getPassword());
	        user.setPassword(encodedPassword);
	        return userRepository.save(user);
	    }
	    
	    public boolean authenticateUser(String username, String password) {
	        User user = userRepository.findByUsername(username);
	        if (user != null) {
	            if (passwordEncoder.matches(password, user.getPassword())) {
	                return true;
	            }
	        }
	        return false;
	    }
	    
	    public User getUserById(Long userId) {
	        return userRepository.findById(userId).orElse(null);
	    }
	    
	    public User saveUser(User user) {
	        return userRepository.save(user);
	    }

	    
	    
	    
	    
}
	    
	    
	


