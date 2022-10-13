package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Analyse;
import com.example.demo.services.AnalyserService;

@RestController
public class AnalyseController implements AnalyseRest {

	@Autowired 
	AnalyserService analServ;
	
	@Override
	public Analyse addAnalyse(Analyse a, long idDoss) {
		return analServ.saveAnalyse(a,idDoss) ; 	
	}

	@Override
	public List<Analyse> findAllAnalysesByDossier(Long id) {
		return analServ.findAnalyses(id) ;
	}

	@Override
	public Analyse editAnalyse(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAnalyseById(Long id) {
		analServ.deleteById(id);	
		
	}


}
