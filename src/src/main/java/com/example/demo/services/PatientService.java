package com.example.demo.services;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.example.demo.utils.medicUtils;
import com.example.demo.models.Categorie;
import com.example.demo.models.Login;
import com.example.demo.models.Patient;
import com.example.demo.repository.LoginRepository;
import com.example.demo.repository.PatientRepository;

@Service
public class PatientService implements PatientServiceInterface {

	@Autowired
	private final PatientRepository patRep;
	
	@Autowired
	PatientRepository patientRepo;
	
	@Autowired
	LoginRepository logRepo;
	

	public ResponseEntity<String> signup(Map<String, String> requestMap){
		//log.info("Inside signup()",requestMap);
		try {
		if(validateSignUpMap(requestMap)) {
			Patient patient = patientRepo.findByEmail(requestMap.get("email"));
			if(Objects.isNull(patient)) {
				patientRepo.save(getPatientFromMap(requestMap));
				logRepo.save(getUserFromMap(requestMap));
				return medicUtils.getResponseEntity("Succesfully Registered!", HttpStatus.OK);
			}else {
				return medicUtils.getResponseEntity("Email already exists !", HttpStatus.BAD_REQUEST);
			}
		
		}
		else {
			return medicUtils.getResponseEntity("Invalid Data", HttpStatus.BAD_REQUEST);
		}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return medicUtils.getResponseEntity("Something is wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private boolean validateSignUpMap(Map<String, String> requestMap) {
		if(requestMap.containsKey("nom")&& requestMap.containsKey("prenom") && requestMap.containsKey("email") && requestMap.containsKey("password")) {
			return true;
		}
		return false;
	}

	private Patient getPatientFromMap(Map<String, String> requestMap) {
		Patient patient = new Patient();
		patient.setNom(requestMap.get("nom"));
		patient.setPrenom(requestMap.get("prenom"));
		patient.setEmail(requestMap.get("email"));
		//patient.setPassword(requestMap.get("password"));
		patient.setPassword(requestMap.get("password"));
		return patient;
	}
	private Login getUserFromMap(Map<String, String> requestMap) {
		Login user = new Login();
		user.setEmail(requestMap.get("email"));
		//patient.setPassword(requestMap.get("password"));
		user.setPassword(requestMap.get("password"));
		user.setUsername(requestMap.get("nom")+" "+requestMap.get("prenom"));
		//user.setPassword(encoder.encode(requestMap.get("password")));

		user.setRole("patient");
		String email=requestMap.get("email");
		System.out.println(email);
		long n=logRepo.findId(email);
		System.out.println(n);

		user.setId(logRepo.findId(email));
		
		return user;
	}
	
	public PatientService(PatientRepository patRep) {
		this.patRep=patRep;
	}
	
	
	/*public Patient findByEmailAndPassword(String email,String password) {
		return patRep.findByEmailAndPassword(email, password);
		
		
	}*/
	public List<Patient> afficherPatient()
	{
		List<Patient> ls = (List<Patient>) patRep.findAll();
		return ls;
	}
	@Override
	public Patient UpdatePatient(Patient p) {
		return patRep.save(p);

	}
	@Override
	public void deletePatient(Patient p) {
		patRep.delete(p);		
	}
	@Override
	public void deletePatientById(Long id) {
		patRep.deleteById(id);
		
	}
	@Override
	public Patient getPatient(Long id) {
		return patRep.findById(id).get();
	}
	
	@Override
	public Optional<Patient> findById(Long id) {
		return patRep.findById(id);
	}
	@Override
	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		return (List<Patient>) patRep.findAll();
	}
	/*@Override
	public Page<Patient> getAllPatientsParPage(int page, int size) {
		
		return Patient.findAll(PageRequest.of(page, size));
	}*/
	@Override
	public Patient savePatient(Patient p) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Long findDossierByIdPatient(Long id) {
		return patRep.findDossier(id);
	}

	

	


	
	
}