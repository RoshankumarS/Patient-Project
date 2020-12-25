package com.example.api.patient.serviceimpl;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.api.patient.dao.PatientRepo;
import com.example.api.patient.exception.PatientException;
import com.example.api.patient.pojo.Patient;
import com.example.api.patient.service.IPatientService;

@Service
public class PatientServiceImpl implements IPatientService {
	
	private String dateRegex = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
	
	private String phoneregex = "^[7-9][0-9]{9}$";
	
	private String validMessage = "Patient Data Submitted Successfully";
	
	private String invalidMessage = "Please Enter a Valid Data";
	
	@Autowired
	private PatientRepo patientRepo;
	
	@Override
	public String saveData(List<Patient> patientList) {
		try {
			for(Patient p : patientList) {
				boolean dob = Pattern.matches(dateRegex, p.getDob());
				boolean phone = Pattern.matches(phoneregex, p.getPhone());
				if(!dob && !phone) {
					throw new PatientException("Invalid Date of Birth and phone No. Entered : " + p.getDob() + " and " + p.getPhone());
				}
				if(!dob) {
					throw new PatientException("Invalid Date of Birth : " + p.getDob());
				}
				if(!phone) {
					throw new PatientException("Invalid phone No. Entered : " + p.getPhone());
				}
			}
			patientList.forEach(p -> patientRepo.save(p));
			return validMessage;
		}
		catch(DataAccessException|NullPointerException e) {
			return invalidMessage;
		}
	}
}
