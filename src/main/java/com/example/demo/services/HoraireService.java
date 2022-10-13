package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Horaire;
import com.example.demo.models.Horaires_disp;
import com.example.demo.models.Medecin;
import com.example.demo.repository.HoraireRepository;
import com.example.demo.repository.MedecinRepository;

@Service
public class HoraireService {

	@Autowired
	HoraireRepository horaireRepo;
	
	@Autowired
	MedecinRepository medRepo;
	
	public Horaire saveHorarire(Horaire h,long idMedecin) {
		Medecin med = medRepo.findById(idMedecin).get();
		h.setMedecin(med);
		return horaireRepo.save(h);
	}

	public Optional<Horaire> findById(Long id) {
		return horaireRepo.findById(id);
	}
	public List<Horaire> findHoraires(Long id){
		return horaireRepo.findHorairesId(id);
	}
}
