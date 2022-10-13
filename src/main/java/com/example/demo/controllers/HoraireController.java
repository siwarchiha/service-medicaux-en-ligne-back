package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Categorie;
import com.example.demo.models.Horaire;
import com.example.demo.models.Horaires_disp;
import com.example.demo.services.HoraireService;

@RestController
public class HoraireController implements HoraireRest {

	@Autowired
	HoraireService horServ ; 
	
	@Override
	public Horaire addHoraire(@RequestBody Horaire h,@PathVariable long idMedecin) {
		return horServ.saveHorarire(h,idMedecin) ; 	
	}
	
	@Override
	public Horaire findHoraireById (@PathVariable long id)  { 
		return horServ.findById(id).get() ;
	}
	
	@Override
	public List<Horaire> findAllHorairesByMedecin (@PathVariable Long id)  { 
		return horServ.findHoraires(id) ;
	}
}
