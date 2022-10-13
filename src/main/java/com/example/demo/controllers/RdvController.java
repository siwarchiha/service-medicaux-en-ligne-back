package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Rendez_vous;
import com.example.demo.services.RdvService;

@RestController
public class RdvController implements RdvRest{

	@Autowired
	//private Smsservice  smsservice ;
	//@Autowired
	RdvService rdvSer;
	@Override
	public Rendez_vous addRdv(@RequestBody Rendez_vous h,@PathVariable long id_med,@PathVariable long id_pat) {
		return rdvSer.saveRdv(h,id_med,id_pat) ; 	
	}
	@Override
	public List<Rendez_vous> findAllrdvPatient(Long id) {
		return rdvSer.findrdv(id) ;
	}
	@Override
	public List<Rendez_vous> findAllrdvMedecin(Long id) {
		return rdvSer.findrdvmed(id) ;
	}
	

	/*public void SMSsender()
	{
		Smsrequest sms = new Smsrequest("+21627919842","Votre Rendez-vous est confirmé");
		smsservice.sendsms(sms);
		}*/
}
