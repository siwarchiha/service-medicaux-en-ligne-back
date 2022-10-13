package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Analyse;
import com.example.demo.models.Consultation;

@RequestMapping("/consultation")
public interface ConsultationReset {


	@PostMapping(path="/add/{idDoss}")
	public Consultation addConsultation(@RequestBody Consultation a,@PathVariable long idDoss);
	
	@GetMapping(path = "show_consultations/{id}")
	public List<Consultation> findAllAConsultationsByDossier (@PathVariable Long id) ;
	
  	@PutMapping(path="/edit")
	public void editConsultationn (@RequestBody Consultation a);
	
	@DeleteMapping("/delete/{id}")
	public void deleteConsultationById ( @PathVariable Long id);
	
	@GetMapping(path = "show/{id}")
	public Consultation findConsultationById (@PathVariable long id);
	
	
	
}

