package com.example.api.patient.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.patient.dao.PatientRepo;
import com.example.api.patient.pojo.Patient;
import com.example.api.patient.service.IPatientService;

@Service
public class PatientServiceImpl implements IPatientService {
	
	@Autowired
	private PatientRepo patientRepo;
	
	@Override
	public String saveData(List<Patient> patientList) {
		patientList.forEach(p->patientRepo.save(p));
		return "Patient Data submitted successfully";
	}

}
