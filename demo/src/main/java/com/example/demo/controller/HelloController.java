package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;
@RestController
public class HelloController{
  
  @GetMapping("/welcome")
  public String greeting(){
    return "HELLO IAM YOGETH";
  }
}