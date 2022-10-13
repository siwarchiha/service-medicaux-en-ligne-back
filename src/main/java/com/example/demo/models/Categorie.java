package com.example.demo.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Categorie implements Serializable{
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 protected Long id;
	 
	 @Column(name = "nom")
	 private String nom ;
	 
		@OneToMany(cascade = CascadeType.ALL,mappedBy ="cat")
		@JsonIgnore
		 private List<Medecin> med=  new ArrayList<>() ;
	
	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nom=" + nom + ", med=" + med + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Medecin> getMed() {
		return med;
	}
	public void setMed(List<Medecin> med) {
		this.med = med;
	}
	


}
