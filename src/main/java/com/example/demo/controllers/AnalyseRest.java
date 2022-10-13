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
import com.example.demo.models.Categorie;

@RequestMapping("/analyse")
public interface AnalyseRest {

	@PostMapping(path="/add/{idDoss}")
	public Analyse addAnalyse(@RequestBody Analyse a,@PathVariable long idDoss);
	
	@GetMapping(path = "show_analyses/{id}")
	public List<Analyse> findAllAnalysesByDossier (@PathVariable Long id) ;
	
  	@PutMapping(path="/edit")
	public void editAnalyse (@RequestBody Analyse a);
	
	@DeleteMapping("/delete/{id}")
	public void deleteAnalyseById ( @PathVariable Long id);
	
	@GetMapping(path = "show/{id}")
	public Analyse findAnalyseById (@PathVariable long id);
	
	
	
}
