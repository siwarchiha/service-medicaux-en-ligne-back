package com.example.demo.models;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class User implements Serializable{

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 protected Long id;
	 
	 @Column(name = "nom")
	 protected String nom;
	 
	 @Column(name = "prenom")
      protected String prenom;
	 
	 public User( String nom, String prenom, String email, String password, String sexe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.sexe = sexe;
	}
	
	@Column(name="email")
	  protected String email;
	 
	 @Column(name = "password")
     protected String password ; 
	 
	 @Column(name = "sexe")
     protected String sexe;
	 
	public Long getId() {
		return id;
	}
	  public User()
	  {
		  
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	 @Override
		public String toString() {
			return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password=" + password
					+ ", sexe=" + sexe + "]";
		}
	



}
