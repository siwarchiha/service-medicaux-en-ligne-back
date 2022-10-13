package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.models.Analyse;
import com.example.demo.models.Antecedent;
import com.example.demo.models.Dossier_Medical;
import com.example.demo.repository.AnalyseRepository;
import com.example.demo.repository.AntecedentRepository;
import com.example.demo.repository.DossierRepository;
@Service
public class AntecedentService {
	@Autowired
	DossierRepository dosRepo;
	
	@Autowired
	AntecedentRepository antRepo;

	public Antecedent saveAntecedent(Antecedent a,long idDoss) {
		Dossier_Medical doss = dosRepo.findById(idDoss).get();
		a.setDossier(doss);
		return antRepo.save(a); 
	}
	public List<Antecedent> findAntecedents(Long id){
		return antRepo.findAntecedentsId(id);
	}
	
	public void deleteByyId(Long id) {
		antRepo.deleteById(id);
	}
	public Antecedent getAntecedentById(Long id)
	{   return antRepo.findAntecedentById(id);
	}
	public Optional<Antecedent> findById(Long id) {
		return antRepo.findById(id);
	}
	@Transactional
	public void editAntecedent(@RequestBody Antecedent a) {
		 antRepo.edit(a.getId(),a.getNom(),a.getCategorie());
	}
}

