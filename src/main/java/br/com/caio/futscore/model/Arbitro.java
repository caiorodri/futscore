package br.com.caio.futscore.model;

import java.io.Serializable;

import br.com.caio.futscore.dto.ArbitroDTO;
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
@EqualsAndHashCode(of = "id")
@Table(name = "arbitro")
public class Arbitro implements Serializable {

	private static final long serialVersionUID = -5150467317113191173L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "partidas")
	private Integer partidas;

	@Column(name = "cartoesVermelho")
	private Integer cartoesVermelho;

	@Column(name = "cartoesAmarelo")
	private Integer cartoesAmarelo;

	@JoinColumn(name = "id_pais")
	@ManyToOne
	private Pais nacionalidade;
	
	public Arbitro(ArbitroDTO arbitroDTO) {

		this.id = arbitroDTO.getId();
		this.nome = arbitroDTO.getNome();
		this.partidas = arbitroDTO.getPartidas();
		this.cartoesAmarelo = arbitroDTO.getCartoesAmarelo();
		this.cartoesVermelho = arbitroDTO.getCartoesVermelho();

	}

	public Arbitro(Long id) {
		this.id = id;
	}
	
	
}
