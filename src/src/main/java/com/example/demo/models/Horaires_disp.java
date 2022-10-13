package com.example.demo.models;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="horairesDisp")
public class Horaires_disp implements Serializable {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	 @Column(name = "debut")

	 private String deb;
	 @Column(name = "fin")

     private String fin;
	 @Column(name = "duree_consultation")
	 private int durée_consultation;
	 @ManyToOne
	 private Medecin medecin;
	 @ManyToOne
	 private Chef_Laboratoire chef_labo;
	public Horaires_disp(Long id, String deb, String fin, int durée_consultation, Medecin medecin) {
		super();
		this.id = id;
		this.deb = deb;
		this.fin = fin;
		this.durée_consultation = durée_consultation;
		this.medecin = medecin;
	}
	
	public Medecin getMedecin() {
		return medecin;
	}
	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
	public String getDeb() {
		return deb;
	}
	@Override
	public String toString() {
		return "horaire [deb=" + deb + ", fin=" + fin + ", durée_consultation=" + durée_consultation + "]";
	}
	public void setDeb(String deb) {
		this.deb = deb;
	}
	public String getFin() {
		return fin;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}
	public int getDurée_consultation() {
		return durée_consultation;
	}
	public void setDurée_consultation(int durée_consultation) {
		this.durée_consultation = durée_consultation;
	}
	
	//methode generant les horaires automatiquement pour chaque medecin
	
	
	
	
	
	
}
