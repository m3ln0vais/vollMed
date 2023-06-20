package voll.med.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotBlank(message = "Não deve estar em branco")
	private String logradouro;
	private String bairro;
	@NotBlank(message = "Não deve estar em branco")
	private String cep;
	@NotBlank(message = "Não deve estar em branco")
	private String numero;
	@NotBlank(message = "Não deve estar em branco")
	private String complemento;
	@NotBlank(message = "Não deve estar em branco")
	private String cidade;
	@NotBlank(message = "Não deve estar em branco")
	private String uf;

	public Address() {

	}
}
