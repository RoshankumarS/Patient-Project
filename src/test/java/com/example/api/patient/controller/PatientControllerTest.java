package com.example.api.patient.controller;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.api.patient.pojo.Patient;
import com.example.api.patient.service.IPatientService;

@RunWith(MockitoJUnitRunner.class)
public class PatientControllerTest {
	
	@InjectMocks
	private PatientController patientController;
	
	@Mock
	private IPatientService patientServices;

	@Test
	public void givenValidInput_shouldSavePatientData() {
		
		//Given
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		patientList.add(getPatientData());
		Mockito.doReturn("def").when(patientServices).saveData(patientList);
		String msg = patientController.savePatientData(patientList);
		Assert.assertFalse(msg.isEmpty());
	}
	
	private Patient getPatientData() {
		Patient patientData = new Patient();
		patientData.setName("abc");
		patientData.setDob("2000-12-30");
		patientData.setPhone("8888888888");
		return patientData;
	}

}
