package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Horaire;

public interface HoraireRepository extends JpaRepository<Horaire,Long> {

	@Query("select h from Horaire h where h.medecin.id=:id")
	List<Horaire> findHorairesId(@Param("id") Long id);
}
