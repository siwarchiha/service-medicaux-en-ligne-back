package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Categorie;
import com.example.demo.models.Medecin;

@RequestMapping("/categorie")
public interface CategorieRest {

	@PostMapping(path="/add")
	public Categorie addCategorie (@RequestBody Categorie categorie);
	
	@GetMapping(path="/list")
	public List<Categorie> findAllCategorie ();
	
	@GetMapping(path = "show/{id}")
	public Categorie findCategorieById (@PathVariable long id);
	
	@PutMapping(path="/edit")
	public Categorie editCategorie (@RequestBody Categorie categorie);
	
	@DeleteMapping("/delete")
	public void deleteCategorie (@RequestBody Categorie categorie);
	
	@DeleteMapping("/delete/{id}")
	public void deleteCategorieById ( @PathVariable Long id);
	
	@GetMapping(path="/list_medecins/{id}")
	public List<Medecin> findAllMedecinsByCategorie (@PathVariable Long id);

}
