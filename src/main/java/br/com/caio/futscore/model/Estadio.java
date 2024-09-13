package br.com.caio.futscore.model;

import java.io.Serializable;

import br.com.caio.futscore.dto.EstadioDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estadio implements Serializable {

	private static final long serialVersionUID = -4968284380885635045L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	@ManyToOne
	@JoinColumn(name = "id_pais")
	private Pais pais;

	private int capacidade;

	public Estadio(EstadioDTO estadioDTO) {

		this.id = estadioDTO.getId();
		this.nome = estadioDTO.getNome();
		this.pais = new Pais(estadioDTO.getPais());
		this.capacidade = estadioDTO.getCapacidade();

	}
}
