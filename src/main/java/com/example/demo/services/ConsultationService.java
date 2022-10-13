package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.models.Analyse;
import com.example.demo.models.Consultation;
import com.example.demo.models.Dossier_Medical;
import com.example.demo.repository.AnalyseRepository;
import com.example.demo.repository.ConsultationRepository;
import com.example.demo.repository.DossierRepository;

@Service
public class ConsultationService {
	
	@Autowired
	DossierRepository dosRepo;
	
	@Autowired
	ConsultationRepository consRepo;

	public Consultation saveConsultation(Consultation a,long idDoss) {
		Dossier_Medical doss = dosRepo.findById(idDoss).get();
		a.setDossier(doss);
		return consRepo.save(a); 
	}
	
	
	public List<Consultation> findConsultations(Long id){
		return consRepo.findConsultationsId(id);
	}
	
	public void deleteById(Long id) {
		consRepo.deleteById(id);
	}
	public Optional<Consultation> findById(Long id) {
		return consRepo.findById(id);
	}
	@Transactional
	public void editConsultation(@RequestBody Consultation a) {
		consRepo.edit(a.getId(),a.getDate(),a.getCommentaire(),a.getMotif());
	}
public Consultation getConsultation(Long id) { return consRepo.getConsultationByid(id);}
}

