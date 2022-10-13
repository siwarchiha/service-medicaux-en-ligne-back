package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Login;
import com.example.demo.models.Patient;
import com.example.demo.repository.LoginRepository;
import com.example.demo.repository.PatientRepository;
import com.example.demo.response.ResponseMessage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
public class AuthController implements AuthRest {

	@Autowired
	PatientRepository patientRepo;
	
/*	@Autowired
	private PasswordEncoder encoder;*/
	
	/*@PostMapping("register")
	public ResponseEntity<ResponseMessage> registerUser(@RequestBody Patient registerRequest){
		if(patientRepo.existsByEmail(registerRequest.getEmail()))
		{
			return new ResponseEntity<>(new ResponseMessage("Email already exists !"),HttpStatus.BAD_REQUEST );
		}
		Patient patient = new Patient(registerRequest.getNom(),registerRequest.getPrenom(),registerRequest.getEmail(),registerRequest.getPassword(),registerRequest.getSexe(),registerRequest.getDate_naiss(),registerRequest.getTel());
	//	Patient patient = new Patient(registerRequest.getNom(),registerRequest.getPrenom(),registerRequest.getEmail(),encoder.encode(registerRequest.getPassword()),registerRequest.getSexe(),registerRequest.getDate_naiss(),registerRequest.getTel());

		patient.setRole("patient");
		patientRepo.save(patient);
		return new ResponseEntity<>(new ResponseMessage("patient registred successfully !"),HttpStatus.OK );

	}*/
	

	@Autowired
	LoginRepository logRepo;
	
	@CrossOrigin(origins= "http://localhost:4200")
	@Override
	public Login loginPatient(@RequestBody Login user ) throws Exception {
		Login userObj=null;
		String tempEmail= user.getEmail();
		String tempPassword = user.getPassword();
		
		if (tempEmail !=null && tempPassword!=null) {
			userObj=logRepo.findByEmailAndPassword(tempEmail,tempPassword);

		}
		if (userObj == null) {
			throw new Exception("patient does not exist bad credentials");
		}
		return userObj;
	}

}
