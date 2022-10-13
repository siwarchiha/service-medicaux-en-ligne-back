package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Analyse;
import com.example.demo.models.Antecedent;
import com.example.demo.services.AnalyserService;
import com.example.demo.services.AntecedentService;

@RestController
public class AntecedentController implements AntecedentReset{


	@Autowired 
	AntecedentService antServ;
	
	@Override
	public Antecedent addAntecedent(Antecedent a, long idDoss) {
		return antServ.saveAntecedent(a,idDoss) ; 	
	}

	@Override
	public List<Antecedent> findAllAntecedentsByDossier(Long id) {
		return antServ.findAntecedents(id) ;
	}

	@Override
	public void editAntecedentEntity(@RequestBody Antecedent a) {
		 antServ.editAntecedent(a);
		
	}

	@Override
	public void deleteAntecedentById(Long id) {
		antServ.deleteByyId(id);	
		
	}

	

	@Override
	public Antecedent getbyId(long id) {
		return antServ.getAntecedentById(id) ;
		
	}

	


}

