package com.example.demo.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@NamedQuery(name="Patient.findByEmailId",query="select p from Patient p where p.email=:email ")
@Entity
public class Patient extends User  {
	
	
	private String date_naiss;
	private Long tel ;
	
	@OneToOne()
	private Dossier_Medical dossier;
	
	@ManyToMany(cascade = CascadeType.ALL)
    private List<Medecin> med;
	
	@OneToMany(mappedBy="pat")
	@JsonIgnore
	private List<Rendez_vous> rdv;
	
	public Patient() {
		super();
	}

	public Patient(String nom , String prenom, String email , String password , String sexe,String date_naiss, Long tel) {
		super(nom,prenom,email,password,sexe);
		this.date_naiss=date_naiss;
		this.tel=tel;
	}

	public String getDate_naiss() {
		return date_naiss;
	}

	public void setDate_naiss(String date_naiss) {
		this.date_naiss = date_naiss;
	}

	public Long getTel() {
		return tel;
	}

	public void setTel(Long tel) {
		this.tel = tel;
	}

	public Dossier_Medical getDossier() {
		return dossier;
	}

	public void setDossier(Dossier_Medical dossier) {
		this.dossier = dossier;
	}

	public List<Medecin> getMed() {
		return med;
	}

	public void setMed(List<Medecin> med) {
		this.med = med;
	}

	public List<Rendez_vous> getRdv() {
		return rdv;
	}

	public void setRdv(List<Rendez_vous> rdv) {
		this.rdv = rdv;
	}

	
	
}
