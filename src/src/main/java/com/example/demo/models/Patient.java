package com.example.demo.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

@NamedQuery(name="Patient.findByEmailId",query="select p from Patient p where p.email=:email ")
@Entity
public class Patient extends User  {
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date date_naiss;
	private int tel ;
	@OneToOne()
	private Dossier_Medical dossier;
@ManyToMany(cascade = CascadeType.ALL)
    private Set<Medecin> med;
	
	public Patient() {
		super();
	}

	public Patient(String nom , String prenom, String email , String password , String sexe,Date date_naiss, int tel) {
		super(nom,prenom,email,password,sexe);
		this.date_naiss=date_naiss;
		this.tel=tel;
	}
	
	public Date getDate_naiss() {
		return date_naiss;
	}
	public void setDate_naiss(Date date_naiss) {
		this.date_naiss = date_naiss;
	}

	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
}
