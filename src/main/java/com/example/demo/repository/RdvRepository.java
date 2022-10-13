package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Rendez_vous;


public interface RdvRepository extends JpaRepository<Rendez_vous, Long> {

	@Query("select h from Rendez_vous h where h.pat.id=:id")
	List<Rendez_vous> findRdvId(@Param("id") Long id);
	
	@Query("select h from Rendez_vous h where h.med.id=:id")
	List<Rendez_vous> findRdvMedId(@Param("id") Long id);
}
