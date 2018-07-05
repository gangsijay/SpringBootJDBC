package com.example.SpringBootJDBC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootJDBC.Service.UserService;

@RestController
public class TestJdbcController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/saveUser")
	public String saveUser() {
		userService.create(2,"张三1", 42);
		return "success";
	}
}
