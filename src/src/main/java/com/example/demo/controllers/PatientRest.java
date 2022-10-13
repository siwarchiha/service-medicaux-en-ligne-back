package com.example.demo.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Login;
import com.example.demo.models.Patient;

@RequestMapping("/patient")
public interface PatientRest {

	@PostMapping(path="/signup")
	public ResponseEntity<String> signup(@RequestBody(required=true) Map<String,String>requestMap);

	/*@PostMapping(path="/login")
	public ResponseEntity<String> login(@RequestBody(required=true) Map<String,String>requestMap);*/

	/*@PostMapping(path="/login")
	public Login login(@RequestBody(required=true) Map<String,String>requestMap);*/

	@GetMapping(path="/show/{id}")
	public Patient findPatientById (@PathVariable long id) ;
	
	@GetMapping(path="/get/{id}")
	public Long getPatientByDossierId(@PathVariable long id);
}
