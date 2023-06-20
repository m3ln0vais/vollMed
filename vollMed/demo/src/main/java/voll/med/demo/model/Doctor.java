package voll.med.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import voll.med.demo.Speciality;

@Table(name = "doctors")
@Entity
@Getter
@Setter
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Não deve estar em branco")
	@Size(min = 3, message = "O minimo é de 3 letras.")
	private String name;
	@Email
	@NotBlank(message = "Não deve estar em branco")
	private String email;
	@NotBlank(message = "Não deve estar em branco")
	@Size(min = 9, max = 14, message = "Número inválido")
	private String telefone;
	@NotBlank(message = "Não deve estar em branco")
	@Size(min = 9, message = "CRM inválido")
	private String crm;
	@Enumerated(EnumType.STRING)
	private Speciality speciality;
	@OneToOne(cascade = CascadeType.ALL)
	@Valid
	private Address address;
	private Boolean ativo;

	public Doctor(Long id) {
		this.id = id;
	}

	public Doctor() {
	}

	public void excluir() {
		this.ativo = false;

	}

}
