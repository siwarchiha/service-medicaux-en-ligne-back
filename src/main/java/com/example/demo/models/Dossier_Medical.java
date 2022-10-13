package com.example.demo.models;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="dossier")
public class Dossier_Medical implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	 
	@OneToMany(mappedBy="dossier")
	@JsonIgnore
	private List<Antecedent> antecedents;
	
	@OneToMany(mappedBy="dossier")
	@JsonIgnore
	private List<Analyse> analyses;
	
	@OneToMany(mappedBy="dossier")
	@JsonIgnore
	private List<Consultation> consultations;
	
	@OneToOne(mappedBy = "dossier")
	private Patient patient;

	public Dossier_Medical() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Antecedent> getAntecedents() {
		return antecedents;
	}

	public void setAntecedents(List<Antecedent> antecedents) {
		this.antecedents = antecedents;
	}

	public List<Analyse> getAnalyses() {
		return analyses;
	}

	public void setAnalyses(List<Analyse> analyses) {
		this.analyses = analyses;
	}

	public List<Consultation> getConsultations() {
		return consultations;
	}

	public void setConsultations(List<Consultation> consultations) {
		this.consultations = consultations;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	 
	
	

}