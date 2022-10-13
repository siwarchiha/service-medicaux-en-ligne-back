package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Login {

	@Id
	  private Long id;
	  private String email;
	  private String password ; 
	  private String role;
	  private String username;
	public Login() {
		// TODO Auto-generated constructor stub
	}
	public Login(String email, String password, String role,String username) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
		this.username=username;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	

}
