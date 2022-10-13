package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Analyse;

public interface AnalyseRepository extends JpaRepository<Analyse, Long> {
	
	@Query("select a from Analyse a where a.dossier.id=:id")
	List<Analyse> findAnalysesId(@Param("id") Long id);

}
