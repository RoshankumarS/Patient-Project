package com.example.api.patient.service;

import java.util.List;

import com.example.api.patient.pojo.Patient;

public interface IPatientService {

	public String saveData(List<Patient> patientList);
}
