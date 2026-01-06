package com.example.demo.securityConfig;
import org.springframework.context.annotation.*;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.UserDetails;

@Configuration
public class HelloConfig{
  @Bean 
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
  {
    http.csrf(customizer->customizer.disable());
    http.authorizeHttpRequests(request->request.anyRequest().authenticated());
    http.formLogin(Customizer.withDefaults());
    http.httpBasic(Customizer.withDefaults());
    http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    return http.build();
    
  }
  
  @Bean 
  public UserDetailsService userDetailsService(){
    UserDetails user1=User.username("Wayne")
                   .password(9874)
                   .roles("ADMIN")
                   .build();
     
     UserDetails user2=User.username("Bruce")
                   .password(9884)
                   .roles("USER")
                   .build();              
                   
    return InMemoryUserDetailsManager(user1,user2);
  }
}