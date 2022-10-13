package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Categorie;
import com.example.demo.models.Medecin;
import com.example.demo.services.CategorieService;
@RestController
public class CategorieController implements CategorieRest {

	@Autowired
	CategorieService catServ ; 
	
	@Override
	public Categorie addCategorie(Categorie categorie) {
		return catServ.saveCat(categorie) ; 	
	}
	@Override
	public List<Categorie> findAllCategorie ()  { 
		return catServ.findAll() ;
	}
	@Override
	public Categorie findCategorieById (@PathVariable long id)  { 
		return catServ.findById(id).get() ;
	}
	@Override
	public Categorie editCategorie (@RequestBody Categorie categorie){
		return catServ.saveCat(categorie) ; 	
	}
	
	@Override
	public void deleteCategorie (@RequestBody Categorie categorie){
		catServ.delete(categorie) ;
			
	}
	@Override
	public void deleteCategorieById ( @PathVariable Long id){
		catServ.deleteById(id);			
	}
	
	@Override
	public List<Medecin> findAllMedecinsByCategorie (@PathVariable Long id)  { 
		return catServ.findMedecins(id) ;
	}
}
