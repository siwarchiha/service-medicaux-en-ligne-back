package com.example.demo.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Chef_Laboratoire")
public class Chef_Laboratoire extends User implements Serializable{
	@Column(name="tel_labo")
	 private int tel_labo;
	@Column(name="adresse_labo")
	 private String adresse_labo;
	 @Override
	public String toString() {
		return "Cheflaboratoire ["+super.toString()+"tel_labo=" + tel_labo + ", adresse_labo=" + adresse_labo + "]";
	}
	
	 public Chef_Laboratoire (String nom , String prenom, String email , String password , String sexe, int tel_labo,String adresse_labo) {
		 super( nom,prenom,email,password,sexe);
		 this.tel_labo=tel_labo;
		 this.adresse_labo=adresse_labo;
		 
	 }
	public String getAdresse_labo() {
		return adresse_labo;
	}
	public void setAdresse_labo(String adresse_labo) {
		this.adresse_labo = adresse_labo;
	}
	public int getTel_labo() {
		return tel_labo;
	}
	public void setTel_labo(int tel_labo) {
		this.tel_labo = tel_labo;
	}
	@OneToMany(mappedBy="medecin")
	private List<Horaires_disp> horaires;
}
