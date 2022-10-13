package com.example.demo.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.utils.medicUtils;

import lombok.extern.log4j.Log4j2;

import com.example.demo.models.Dossier_Medical;
import com.example.demo.models.Login;
import com.example.demo.models.Patient;
import com.example.demo.repository.DossierRepository;
import com.example.demo.repository.LoginRepository;
import com.example.demo.repository.PatientRepository;
@Log4j2
@Service
public class PatientService implements PatientServiceInterface {

	@Autowired
	private final PatientRepository patRep;
	
	@Autowired
	PatientRepository patientRepo;
	
	@Autowired
	LoginRepository logRepo;
	
	@Autowired
	DossierRepository dossRep;
	

	
	public ResponseEntity<String> signup(@RequestBody Patient patient){
		//log.info("Inside signup() patient",patient);
		try {
			Patient pat = patientRepo.findByEmail(patient.getEmail());
			System.out.println(pat);
			if(Objects.isNull(pat)) {
				//log.info("Inside if patient",patient);
				patientRepo.save(getPatientInfo(patient));
				//log.info("getPat()",patient);
				logRepo.save(getUser(patient));
				//log.info("getUser()",patient);

				return medicUtils.getResponseEntity("Succesfully Registered!", HttpStatus.OK);
			}else {
				return medicUtils.getResponseEntity("Email already exists !", HttpStatus.BAD_REQUEST);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return medicUtils.getResponseEntity("Something is wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private Patient getPatientInfo(@RequestBody Patient pat) {
		Patient patient = new Patient();
		patient.setNom(pat.getNom());
		patient.setPrenom(pat.getPrenom());
		patient.setEmail(pat.getEmail());
		//patient.setPassword(requestMap.get("password"));
		Random random = new Random();
		Long id=random.nextLong();
		System.out.println(id);
		patient.setId(id);
		patient.setPassword(pat.getPassword());
		patient.setDate_naiss(pat.getDate_naiss());
		patient.setSexe(pat.getSexe());
		patient.setTel(pat.getTel());
		//Long idDoss=random.nextLong();
		//System.out.println(idDoss);
		//dossRep.createDoss(idDoss);
		//System.out.println(doss);
		//patient.setDossier(doss);
		//patient.setDossier(doss);
		return patient;
	}
	private Login getUser(@RequestBody Patient pat) {
		Login user = new Login();
		user.setEmail(pat.getEmail());
		user.setPassword(pat.getPassword());
		user.setUsername(pat.getNom()+" "+pat.getPrenom());
		//user.setPassword(encoder.encode(requestMap.get("password")));

		user.setRole("patient");
		String email=pat.getEmail();
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