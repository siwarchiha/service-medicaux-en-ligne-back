package com.example.demo.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<String> signup(Map<String, String> requestMap) {
	
		try {
			SimpleMailMessage msg = new SimpleMailMessage();
		    msg.setTo(requestMap.get("email"));
	        msg.setSubject("Compte Ajouté");
		    msg.setText("Pour acceder a votre compte sur MEDICO vous utilisez votre email  "+ requestMap.get("email")+" ,votre mot de passe est "+requestMap.get("password"));
		    javaMailSender.send(msg);
			return patServ.signup(requestMap);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return medicUtils.getResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Override
	public Patient findPatientById (@PathVariable long id)  { 
		return patServ.findById(id).get() ;
	}
	
	/*@Override
	public Login login(Map<String, String> user){
		log.info("Inside login()");
		Login userObj=null;
		
			Authentication auth = authMan.authenticate(
					new UsernamePasswordAuthenticationToken(user.get("email"),user.get("password"))
					);
			String em=user.get("email");
			System.out.print(em);
			log.info("Insidefcffffffff");
			if(auth.isAuthenticated()) {
				log.info("Ingtttttttt");
					userObj=logRepo.findByEmailAndPassword(user.get("email"),user.get("password"));
				logRepo.updateToken(jwtutil.generateToken(cusService.getUserDetails().getEmail(), cusService.getUserDetails().getRole()), user.get("email"));
				
			}
			log.info("Inuuuuuuuuuuuuuuu");
		
		return userObj;

	}*/

	@Override
	public Long getPatientByDossierId(@PathVariable long id) {
		return patServ.findDossierByIdPatient(id);
	}

}
