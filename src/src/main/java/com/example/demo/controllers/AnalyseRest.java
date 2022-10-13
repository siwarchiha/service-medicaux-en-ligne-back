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

@RequestMapping("/analyse")
public interface AnalyseRest {

	@PostMapping(path="/add/{idDoss}")
	public Analyse addAnalyse(@RequestBody Analyse a,@PathVariable long idDoss);
	
	@GetMapping(path = "show_analyses/{id}")
	public List<Analyse> findAllAnalysesByDossier (@PathVariable Long id) ;
	
	@PutMapping(path="/edit")
	public Analyse editAnalyse (@PathVariable Long id);
	
	@DeleteMapping("/delete/{id}")
	public void deleteAnalyseById ( @PathVariable Long id);
}
