package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
	
	@Query("select m from Medecin m where m.email =:email and m.password =:password")
	Medecin findByEmailAndPassword (@Param("email") String email,@Param("password") String password);
	Medecin findByEmail(@Param("email") String email);
	
	@Query("select id from Medecin m where m.email =:email")
	Long findId(@Param("email") String email);
	@Query("select m from Medecin m where m.cat.id=:cat")
	List<Medecin> findMedecinId(@Param("cat") Long cat);

	@Modifying
	@Query("update Medecin m set cat.id=:cat where m.id=:id")
	void updateCategorieId(@Param("cat") Long cat,@Param("id") Long id);
}
