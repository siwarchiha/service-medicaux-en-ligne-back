package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Medecin;
import com.example.demo.models.Patient;
import com.example.demo.models.Rendez_vous;
import com.example.demo.repository.MedecinRepository;
import com.example.demo.repository.PatientRepository;
import com.example.demo.repository.RdvRepository;

@Service
public class RdvService {

	@Autowired 
	RdvRepository rdvRepo;
	
	@Autowired
	MedecinRepository medRepo;
	
	@Autowired
	PatientRepository patRepo;
	
	public Rendez_vous saveRdv(Rendez_vous h,long id_med,long id_pat) {
		Medecin med = medRepo.findById(id_med).get();
		h.setMed(med);
		
		Patient pat = patRepo.findById(id_pat).get();
		h.setPat(pat);
		return rdvRepo.save(h);
	}

	public List<Rendez_vous> findrdv(Long id) {
		return rdvRepo.findRdvId(id);
	} 

	public List<Rendez_vous> findrdvmed(Long id) {
		return rdvRepo.findRdvMedId(id);
	} 
}

