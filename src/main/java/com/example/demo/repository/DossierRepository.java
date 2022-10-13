package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Dossier_Medical;


public interface DossierRepository extends JpaRepository<Dossier_Medical, Long> {

}
