package com.example.demo.securityConfig;
import org.springframework.context.annotation.*;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class HelloConfig{
  @Bean 
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
  {
    return http.build();
    
  }
}