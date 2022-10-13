package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Categorie;
import com.example.demo.models.Medecin;
import com.example.demo.repository.CategorieRepository;

@Service
public class CategorieService implements CategoriServiceInterface {

	@Autowired
	CategorieRepository catRepo;
	@Override
	public Categorie saveCat(Categorie c) {
		return catRepo.save(c);
	}
	
	public List<Categorie> findAll() {
		return catRepo.findAll();
	}
	
	public Optional<Categorie> findById(Long id) {
		return catRepo.findById(id);
	}
	
	public void deleteById(Long id) {
		catRepo.deleteById(id);
	}

	public void delete(Categorie c) {
		catRepo.delete(c);
	} 

	public List<Medecin> findMedecins(Long id){
		return catRepo.findMedecinId(id);
	}


}
