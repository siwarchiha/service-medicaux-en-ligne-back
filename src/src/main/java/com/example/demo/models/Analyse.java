package com.example.demo.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Embeddable
public class Analyse implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;

	private String nom;
	private String resultat; 
	private String date;
	
	 @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Dossier_Medical dossier;

	
	@Override
	public String toString() {
		return "Analyse [id=" + id + ", nom=" + nom + ", resultat=" + resultat + ", date=" + date + "]";
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
	public String getResultat() {
		return resultat;
	}
	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Dossier_Medical getDossier() {
		return dossier;
	}
	public void setDossier(Dossier_Medical dossier) {
		this.dossier = dossier;
	}

	

}
