package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Categorie;
import com.example.demo.models.Medecin;



public interface CategorieRepository extends JpaRepository<Categorie, Long> {

	@Query("select m from Medecin m where m.cat.id=:cat")
	List<Medecin> findMedecinId(@Param("cat") Long cat);
	
	@Query("select c from Categorie c where c.nom=:nom")
	Categorie findCategorieByNom(@Param("nom")String nom);
}
