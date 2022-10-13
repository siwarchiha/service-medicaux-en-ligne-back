package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Analyse;
import com.example.demo.models.Antecedent;

public interface AntecedentRepository extends JpaRepository<Antecedent, Long> {
	/*@Query("Delete a from Antecedent a where a.dossier.id=:id")
	Antecedent deletebyidDoss(@Param("id") Long id);*/
	
	@Query("select a from Antecedent a  where a.dossier.id=:id")
	List<Antecedent> findAntecedentsId(@Param("id") Long id);
	@Query("select a from Antecedent a where a.id=:id")
	Antecedent findAntecedentById(@Param("id") Long id);
	/*update*/
	@Modifying
	@Query("update Antecedent a set a.nom=:nom , a.categorie=:categorie where a.id=:id")
	void edit(@Param("id") Long id,@Param("nom") String nom,@Param("categorie") String categorie);

	
	
}
