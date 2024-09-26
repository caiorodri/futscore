package br.com.caio.futscore.model;

import java.io.Serializable;
import java.util.Date;

import br.com.caio.futscore.dto.PartidaDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Partida implements Serializable {

	private static final long serialVersionUID = -2214448128018278776L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_competicao_ano")
	private CompeticaoAno competicaoAno;

	@ManyToOne
	@JoinColumn(name = "id_clube_mandante")
	private Clube clubeMandante;

	@ManyToOne
	@JoinColumn(name = "id_clube_visitante")
	private Clube clubeVisitante;

	@ManyToOne
	@JoinColumn(name = "id_estadio")
	private Estadio estadio;

	@ManyToOne
	@JoinColumn(name = "id_arbitro")
	private Arbitro arbitro;

	@Column(name = "mando_campo_neutro")
	private Boolean mandoCampoNeutro;

	@Column(name = "quantidade_torcedores")
	private Integer quantidadeTorcedores;
	
	@Column(name = "gols_clube_mandante")
	private Integer golsClubeMandante;

	@Column(name = "gols_clube_visitante")
	private Integer golsClubeVisitante;
	
	@Column(name = "data_partida")
	private Date dataPartida;
	
	@Column(name = "partida_realizada")
	private Boolean partidaRealizada;
	
	public Partida(PartidaDTO partidaDTO) {

		this.id = partidaDTO.getId();
		this.mandoCampoNeutro = partidaDTO.getMandoCampoNeutro();
		this.quantidadeTorcedores = partidaDTO.getQuantidadeTorcedores();
		this.golsClubeMandante = partidaDTO.getGolsClubeMandante();
		this.golsClubeVisitante = partidaDTO.getGolsClubeVisitante();
		this.partidaRealizada = partidaDTO.getPartidaRealizada();
		this.dataPartida = partidaDTO.getDataPartida();

	}

	public Partida(Long id) {
		this.id = id;
	}
	
	

}
