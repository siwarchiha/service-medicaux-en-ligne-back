package com.example.demo.models;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="medecin")
public class Medecin extends User implements Serializable{
	@Column(name = "matricule")
	 private Long matricule ; 

	@Column(name = "specialite")
    private String specialite ;
	
	@Column(name = "prix_consultation")
    private float prix_consult;
	 
	@OneToMany(mappedBy="medecin")
	@JsonIgnore
	private List<Horaire> horaires;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy="med")
    private Set<Patient> pat;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Categorie cat;
	
	 @Override
	public String toString() {
		return "Medecin ["+super.toString()+"matricule=" + matricule + ", statut=" + specialite + ", prix_consult=" + prix_consult + "]";
	}
	/* @JsonCreator
	 public Medecin (@JsonProperty("medecin_id") Long medecin_id ) {
	     this.id = medecin_id;
	 }*/
	
	public Long getMatricule() {
		return matricule;
	}
	 public Medecin (String nom , String prenom, String email , String password , String sexe, Long matricule,String specialite, float prix_consult) {
		 super( nom,prenom,email,password,sexe);
		 this.matricule=matricule;
		 this.specialite=specialite;
		 this.prix_consult=prix_consult;
		 
	 }
	public Medecin() {
		// TODO Auto-generated constructor stub
	}

	public void setMatricule(Long matricule) {
		this.matricule = matricule;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String statut) {
		this.specialite = statut;
	}
	public float getPrix_consult() {
		return prix_consult;
	}
	public void setPrix_consult(float prix_consult) {
		this.prix_consult = prix_consult;
	}

	public List<Horaire> getHoraires() {
		return horaires;
	}

	public void setHoraires(List<Horaire> horaires) {
		this.horaires = horaires;
	}

	public Set<Patient> getPat() {
		return pat;
	}

	public void setPat(Set<Patient> pat) {
		this.pat = pat;
	}

	public Categorie getCat() {
		return cat;
	}

	public void setCat(Categorie cat) {
		this.cat = cat;
	} 

	 
}