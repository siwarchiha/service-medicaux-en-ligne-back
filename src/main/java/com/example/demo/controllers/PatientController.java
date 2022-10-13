package com.example.demo.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Categorie;
import com.example.demo.models.Patient;
import com.example.demo.repository.LoginRepository;
import com.example.demo.services.PatientService;
import com.example.demo.utils.medicUtils;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@CrossOrigin(origins= "http://localhost:4200")

public class PatientController implements PatientRest {

	@Autowired
	PatientService patServ;
	
	@Autowired
	private JavaMailSender javaMailSender;
	/*@Autowired
	AuthenticationManager authMan;
	@Autowired 
	CustomerUserDetailsService cusService;
	
	@Autowired
	JwtUtil jwtutil;*/
	@Autowired
	LoginRepository logRepo;
	
	@CrossOrigin(origins= "http://localhost:4200")
	@Override
	public ResponseEntity<String> signup(@RequestBody Patient patient) {
	
		try {
			SimpleMailMessage msg = new SimpleMailMessage();
		    msg.setTo(patient.getEmail());
	        msg.setSubject("Compte Ajouté");
		    msg.setText("Pour acceder a votre compte sur MEDICO vous utilisez votre email  "+ patient.getEmail()+" ,votre mot de passe est "+patient.getPassword());
		    javaMailSender.send(msg);
			return patServ.signup(patient);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return medicUtils.getResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Override
	public Patient findPatientById (@PathVariable long id)  { 
		return patServ.findById(id).get() ;
	}
	

	@Override
	public Long getPatientByDossierId(@PathVariable long id) {
		return patServ.findDossierByIdPatient(id);
	}

}
