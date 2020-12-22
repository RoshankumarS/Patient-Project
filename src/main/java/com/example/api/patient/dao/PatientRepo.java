package com.example.api.patient.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.api.patient.pojo.Patient;

public interface PatientRepo extends CrudRepository<Patient, Integer>{

}
