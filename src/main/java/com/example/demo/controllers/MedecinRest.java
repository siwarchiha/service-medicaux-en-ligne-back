package com.example.demo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Medecin;

@RequestMapping("/medecin")
public interface MedecinRest {

	@PostMapping(path="/signup")
	public ResponseEntity<String> signup(@RequestBody Medecin medecin);
	
	@GetMapping(path="/list_medecins/{id}")
	public List<Medecin> findAllMedecinsByCategorie (@PathVariable Long id);
	
	@GetMapping(path="/show/{id}")
	public Medecin findMedecinById (@PathVariable long id) ;
}
