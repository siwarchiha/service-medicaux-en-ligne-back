package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Patient;

public interface PatientServiceInterface {

	Patient UpdatePatient(Patient p);
	void deletePatient(Patient p);
	void deletePatientById(Long id);
	Patient getPatient(Long id);
	List<Patient> getAllPatients();
    Patient savePatient(Patient p);
	List<Patient> afficherPatient();
	
	Optional<Patient> findById(Long id);
}
