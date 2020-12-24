package com.example.api.patient.serviceimpl;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.api.patient.dao.PatientRepo;
import com.example.api.patient.pojo.Patient;

@RunWith(MockitoJUnitRunner.class)
public class PatientServiceImplTest {

	@InjectMocks
	private PatientServiceImpl patientServiceImpl;
	
	@Mock
	private PatientRepo patientRepo;
	
	@Test
	public void givenValidData_shouldSaveData() {
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		patientList.add(getPatientData());
		String msg = patientServiceImpl.saveData(patientList);
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
