package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Rendez_vous;

@RequestMapping("/rdv")
public interface RdvRest {
	
	@PostMapping(path="/add/{id_med}/{id_pat}")
	public Rendez_vous addRdv(@RequestBody Rendez_vous h,@PathVariable long id_med,@PathVariable long id_pat);
	@GetMapping(path = "show_rdvpat/{id}")
	public List<Rendez_vous> findAllrdvPatient (@PathVariable Long id) ;
	@GetMapping(path = "show_rdvmed/{id}")
	public List<Rendez_vous> findAllrdvMedecin (@PathVariable Long id) ;
}
