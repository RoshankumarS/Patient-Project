package com.example.api.patient.serviceimpl;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.api.patient.dao.PatientRepo;
import com.example.api.patient.exception.PatientException;
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
	
	@Test(expected = PatientException.class)
	public void givenInvalidDobAndPhone_shouldThrowException() {
		Patient patientData = new Patient();
		patientData.setName("abc");
		patientData.setDob("30-02-2020");
		patientData.setPhone("88888888888");
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		patientList.add(patientData);
		patientServiceImpl.saveData(patientList);
	}
	
	@Test(expected = PatientException.class)
	public void givenInvalidDob_shouldThrowException() {
		Patient patientData = new Patient();
		patientData.setName("abc");
		patientData.setDob("30-02-2020");
		patientData.setPhone("8888888888");
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		patientList.add(patientData);
		patientServiceImpl.saveData(patientList);
	}
	
	@Test(expected = PatientException.class)
	public void givenInvalidPhone_shouldThrowException() {
		Patient patientData = new Patient();
		patientData.setName("abc");
		patientData.setDob("23-02-2020");
		patientData.setPhone("88888888888");
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		patientList.add(patientData);
		patientServiceImpl.saveData(patientList);
	}
	
	@Test
	public void givenInvalidData_shouldThrowException() {
		Patient patientData = new Patient();
		patientData.setName("abc");
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		patientList.add(patientData);
		patientServiceImpl.saveData(patientList);
	}

	private Patient getPatientData() {
		Patient patientData = new Patient();
		patientData.setName("abc");
		patientData.setDob("23-02-2020");
		patientData.setPhone("8888888888");
		return patientData;
	}
}
