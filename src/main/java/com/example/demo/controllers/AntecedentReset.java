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
import com.example.demo.models.Antecedent;

@RequestMapping("/antecedent")
public interface AntecedentReset {

	@PostMapping(path="/add/{idDoss}")
	public Antecedent addAntecedent(@RequestBody Antecedent a,@PathVariable long idDoss);
	
	@GetMapping(path = "show_antecedents/{id}")
	public List<Antecedent> findAllAntecedentsByDossier (@PathVariable Long id) ;
	
	@PutMapping(path="/edit")
	public void editAntecedentEntity (@RequestBody Antecedent a);
	
	@DeleteMapping("/delete/{id}")
	public void deleteAntecedentById ( @PathVariable Long id);
	
	@GetMapping(path = "show/{id}")
	public  Antecedent getbyId (@PathVariable long id);
	
}

