package voll.med.demo.dto;

import voll.med.demo.Speciality;
import voll.med.demo.model.Doctor;

public record DoctorGetDTO(String nome, String email, String crm, Speciality speciality) {
	public DoctorGetDTO(Doctor doctor) {
		this(doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpeciality());
	}
}
