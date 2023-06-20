package voll.med.demo;

import static java.util.Arrays.asList;
import java.util.Objects;

public enum Speciality {
	ORTOPEDIA(1, "Ortopedia"), 
	CARDIOLOGIA(2, "Cardiologia"), 
	GINECOLOGIA(3, "Ginecologista"), 
	DERMATOLOGIA(4, "Dermatologia");

	private Integer id;
	private String speciality;

	private Speciality(Integer id, String name) {
		this.id = id;
		this.speciality = name;
	}

	public Integer getId() {
		return id;
	}

	public String getSpeciality() {
		return speciality;
	}

	public static Speciality get(Integer id) {
		return asList(values())
                .stream()
                .filter(x -> Objects.equals(x.id, id))
                .findFirst()
                .get();
	}
}
