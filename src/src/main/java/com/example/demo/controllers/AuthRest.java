package com.example.demo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Login;

@RequestMapping("/home")
public interface AuthRest {
	@PostMapping(path="/login")
	public Login loginPatient(@RequestBody Login user ) throws Exception;

}
