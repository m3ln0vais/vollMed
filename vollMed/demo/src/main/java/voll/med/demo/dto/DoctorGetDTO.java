package voll.med.demo.dto;

import voll.med.demo.Speciality;
import voll.med.demo.model.Doctor;

public record DoctorGetDTO(String nome, String email, String crm, Speciality speciality) {
	public DoctorGetDTO(Doctor doctor) {
		this(doctor.getNome(), doctor.getEmail(), doctor.getCrm(), doctor.getSpeciality());
	}
}
