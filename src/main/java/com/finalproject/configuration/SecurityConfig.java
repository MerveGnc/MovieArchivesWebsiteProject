package com.finalproject.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


import com.finalproject.service.CustomUserDetailsService;




@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }    
	 
	 @Bean
	 public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	        .csrf().disable()
	            .authorizeRequests() 
                .anyRequest().permitAll()
	                .and()
	                .formLogin() 
	                .loginPage("/login") 
	                .defaultSuccessUrl("/search") 
	                .failureUrl("/loginerror") 
	                .loginProcessingUrl("/login") 
	                .usernameParameter("username") 
	                .passwordParameter("password") 
	                .permitAll()
	                .and()
	                .httpBasic();
	        return http.build();
	 }
	           
	    
	 
	 @Autowired
	    private CustomUserDetailsService customUserDetailsService;

	    
	 
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	    }

	 
	    protected void configure(HttpSecurity http) throws Exception {
	   
	    }




}
	    
	    

	