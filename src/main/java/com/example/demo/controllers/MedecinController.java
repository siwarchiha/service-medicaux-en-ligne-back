package com.example.demo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Medecin;
import com.example.demo.services.MedecinService;
import com.example.demo.utils.medicUtils;
@RestController
public class MedecinController implements MedecinRest {
	@Autowired
	MedecinService medServ;
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public ResponseEntity<String> signup(@RequestBody Medecin medecin) {
	
		try {
			SimpleMailMessage msg = new SimpleMailMessage();
		    msg.setTo(medecin.getEmail());
	        msg.setSubject("Compte Ajouté");
		    msg.setText("Pour acceder a votre compte sur MEDICO vous utilisez votre email  "+ medecin.getEmail()+" ,votre mot de passe est "+medecin.getPassword());
		    javaMailSender.send(msg);
			return medServ.signup(medecin);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return medicUtils.getResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Override
	public List<Medecin> findAllMedecinsByCategorie (@PathVariable Long id)  { 
		return medServ.findMedecins(id) ;
	}

	@Override
	public Medecin findMedecinById(long id) {
		return medServ.findById(id).get() ;
	}
}
