package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Analyse;
import com.example.demo.models.Dossier_Medical;
import com.example.demo.repository.AnalyseRepository;
import com.example.demo.repository.DossierRepository;

@Service
public class AnalyserService {
	
	@Autowired
	DossierRepository dosRepo;
	
	@Autowired
	AnalyseRepository analRepo;

	public Analyse saveAnalyse(Analyse a,long idDoss) {
		Dossier_Medical doss = dosRepo.findById(idDoss).get();
		a.setDossier(doss);
		return analRepo.save(a); 
	}
	
	public List<Analyse> findAnalyses(Long id){
		return analRepo.findAnalysesId(id);
	}
	
	public void deleteById(Long id) {
		analRepo.deleteById(id);
	}

}
