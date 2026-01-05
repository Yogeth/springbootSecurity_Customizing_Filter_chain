package com.example.demo.securityConfig;
import org.springframework.context.annotation.*;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.Customizer;

@Configuration
public class HelloConfig{
  @Bean 
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
  {
    http.csrf(customizer->customizer.disable());
    http.authorizeHttpRequests(request->request.anyRequest().authenticated());
    http.formLogin(customizer.withDefaults());
    
    return http.build();
    
  }
}