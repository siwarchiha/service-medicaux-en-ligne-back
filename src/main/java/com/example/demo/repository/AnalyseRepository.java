package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Analyse;

public interface AnalyseRepository extends JpaRepository<Analyse, Long> {
	@Query("select an from Analyse an where an.id=:id ")
	Analyse getAnalyseByid(@Param("id") Long id);
	@Query("select a from Analyse a where a.dossier.id=:id")
	List<Analyse> findAnalysesId(@Param("id") Long id);
	
	
	@Modifying
	@Query("update Analyse a set a.date=:date,a.nom=:nom,a.resultat=:resultat where a.id=:id")
	void edit(@Param("id") Long id,@Param("date") String date,@Param("nom") String nom,@Param("resultat") String resultat);
	
	
}
