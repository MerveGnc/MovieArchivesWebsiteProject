package com.finalproject.service;

//import java.util.Collection;
//import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import com.finalproject.model.CustomUserDetails;
import com.finalproject.model.User;


import com.finalproject.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Kullanıcı bulunamadı: " + username);
        }
        return new CustomUserDetails(user);
    }

//    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
//
//        return Collections.emptyList();
//    }
    
}
