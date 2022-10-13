package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Antecedent;
import com.example.demo.models.Consultation;
import com.example.demo.services.AntecedentService;
import com.example.demo.services.ConsultationService;

@RestController
public class ConsultationController implements ConsultationReset {


	@Autowired 
	ConsultationService consServ;
	
	@Override
	public Consultation addConsultation(Consultation a, long idDoss) {
		return consServ.saveConsultation(a,idDoss) ; 	
	}

	@Override
	public List<Consultation> findAllAConsultationsByDossier(Long id) {
		return consServ.findConsultations(id) ;
	}

	@Override
	public void editConsultationn(@RequestBody Consultation a) {
		consServ.editConsultation(a);
		
	}

	@Override
	public void deleteConsultationById(Long id) {
		consServ.deleteById(id);	
		
	}

	

	@Override
	public Consultation findConsultationById(long id) {
		return consServ.getConsultation(id) ;
		
	}

	


}


