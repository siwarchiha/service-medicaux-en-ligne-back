package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Categorie;
import com.example.demo.models.Horaire;
import com.example.demo.models.Horaires_disp;

@RequestMapping("/horaire")
public interface HoraireRest {
	
	@PostMapping(path="/add/{idMedecin}")
	public Horaire addHoraire(@RequestBody Horaire h,@PathVariable long idMedecin);

	@GetMapping(path = "show/{id}")
	public Horaire findHoraireById (@PathVariable long id);
	
	@GetMapping(path = "show_horaires/{id}")
	public List<Horaire> findAllHorairesByMedecin (@PathVariable Long id) ;
}
