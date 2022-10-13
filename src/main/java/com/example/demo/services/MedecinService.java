package com.example.demo.services;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.models.Categorie;
import com.example.demo.models.Login;
import com.example.demo.models.Medecin;
import com.example.demo.models.Patient;
import com.example.demo.repository.CategorieRepository;
import com.example.demo.repository.LoginRepository;
import com.example.demo.repository.MedecinRepository;
import com.example.demo.repository.PatientRepository;
import com.example.demo.utils.medicUtils;

@Service
public class MedecinService implements MedecinServiceInterface {

	@Autowired
	LoginRepository logRepo;
	
	@Autowired
	MedecinRepository medRepo;
	
	@Autowired
	CategorieRepository catRepo;

	public ResponseEntity<String> signup(@RequestBody Medecin medecin){
		//log.info("Inside signup()",requestMap);
		try {
		
			Medecin medcin = medRepo.findByEmail(medecin.getEmail());
			if(Objects.isNull(medcin)) {
				medRepo.save(getMedecinInfo(medecin));
				logRepo.save(getUser(medecin));
				return medicUtils.getResponseEntity("Succesfully Registered!", HttpStatus.OK);
			}else {
				return medicUtils.getResponseEntity("Email already exists !", HttpStatus.BAD_REQUEST);
			}
		
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return medicUtils.getResponseEntity("Something is wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	

	private Medecin getMedecinInfo(@RequestBody Medecin med) {
		Medecin medecin = new Medecin();
		medecin.setNom(med.getNom());
		medecin.setPrenom(med.getPrenom());
		medecin.setEmail(med.getEmail());
		Random random = new Random();
		Long id=random.nextLong();
		System.out.println(id);
		medecin.setId(id);
		medecin.setPassword(med.getPassword());
		medecin.setMatricule(med.getMatricule());
		medecin.setPrix_consult(med.getPrix_consult());
		medecin.setSexe(med.getSexe());
		medecin.setSpecialite(med.getSpecialite());
		System.out.println("teeeeeeest");
		System.out.println(med.getSpecialite());
		 
		Categorie cat=catRepo.findCategorieByNom(med.getSpecialite());
		System.out.println(cat);
		medecin.setCat(cat);
		/*long id_med=medRepo.findId(med.getEmail());
		System.out.println(id_med);*/
		//medRepo.updateCategorieId(cat, id_med);
		return medecin;
	}
	private Login getUser(@RequestBody Medecin med) {
		Login user = new Login();
		user.setEmail(med.getEmail());
		//patient.setPassword(requestMap.get("password"));
		user.setPassword(med.getPassword());
		//user.setPassword(encoder.encode(requestMap.get("password")));

		user.setRole("medecin");
		String email=med.getEmail();
		System.out.println(email);
		long n=logRepo.findMedecinId(email);
		System.out.println(n);

		user.setId(logRepo.findMedecinId(email));
		
		return user;
	}
	
	public List<Medecin> findMedecins(Long id){
		return medRepo.findMedecinId(id);
	}
	
	
	public Optional<Medecin> findById(Long id) {
		return medRepo.findById(id);
	}


}
