package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Login;

public interface LoginRepository extends JpaRepository<Login, Integer>{

	Login findByEmail(@Param("email") String email);
	
	@Query("select id from Patient p where p.email=:email")
	Long findId(@Param("email") String email);
	
	@Query("select id from Medecin m where m.email=:email")
	Long findMedecinId(@Param("email") String email);
	
	public Login findByEmailAndPassword(String email, String password);

	@Modifying
	@Query("update Login u set token=:token where u.email=:email")
	void updateToken(@Param("email") String email,@Param("token") String token);

}
