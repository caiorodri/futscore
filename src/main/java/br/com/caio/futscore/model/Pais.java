package br.com.caio.futscore.model;

import java.io.Serializable;

import br.com.caio.futscore.dto.PaisDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pais")
@EqualsAndHashCode(of = "id")
public class Pais implements Serializable {

	private static final long serialVersionUID = -1540071270749097194L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome")
	private String nome;

	@ManyToOne
	@JoinColumn(name = "continente_id", nullable = false)
	private Continente continente;

	@Column(name = "imagem")
	private String imagem;

	public Pais(PaisDTO paisDTO) {

		this.id = paisDTO.getId();
		this.nome = paisDTO.getNome();
		this.continente = new Continente(paisDTO.getContinente());
		this.imagem = paisDTO.getImagem();

	}

	public Pais(Integer id) {
		this.id = id;
	}

	
}
