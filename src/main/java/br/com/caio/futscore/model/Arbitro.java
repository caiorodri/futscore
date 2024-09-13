package br.com.caio.futscore.model;

import java.io.Serializable;
import java.util.List;

import br.com.caio.futscore.dto.ArbitroDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	private int partidas;

	@Column(name = "cartoesVermelho")
	private int cartoesVermelho;

	@Column(name = "cartoesAmarelo")
	private int cartoesAmarelo;

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
