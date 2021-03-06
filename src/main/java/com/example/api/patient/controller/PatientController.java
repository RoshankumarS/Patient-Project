package com.example.api.patient.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.patient.pojo.Patient;
import com.example.api.patient.service.IPatientService;

@RestController
public class PatientController {
	
	@Autowired
	private IPatientService patientServices;
	
	@PostMapping(path = "/save", consumes="application/json")
	public String savePatientData(@RequestBody ArrayList<Patient> patientList){
		return patientServices.saveData(patientList);
	}
}
