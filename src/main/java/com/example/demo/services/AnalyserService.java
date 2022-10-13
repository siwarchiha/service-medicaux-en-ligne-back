package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.models.Analyse;
import com.example.demo.models.Categorie;
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
	public Optional<Analyse> findById(Long id) {
		return analRepo.findById(id);
	}
	@Transactional
	public void editAnalyse(@RequestBody Analyse a) {
		 analRepo.edit(a.getId(),a.getDate(),a.getNom(),a.getResultat());
	}
public Analyse getAnalyse(Long id) { return analRepo.getAnalyseByid(id);}
}
