package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Analyse;
import com.example.demo.models.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation, Long>{
	@Query("select an from Consultation an where an.id=:id ")
	Consultation getConsultationByid(@Param("id") Long id);
	@Query("select a from Consultation a where a.dossier.id=:id")
	List<Consultation> findConsultationsId(@Param("id") Long id);
	
	
	@Modifying
	@Query("update Consultation a set a.date=:date,a.commentaire=:commentaire,a.motif=:motif where a.id=:id")
	void edit(@Param("id") Long id,@Param("date") String date,@Param("commentaire") String commentaite,@Param("motif") String motif );
	
}
