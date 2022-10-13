package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Categorie;

public interface CategoriServiceInterface {

	Categorie saveCat(Categorie c);
	List<Categorie> findAll();
}
