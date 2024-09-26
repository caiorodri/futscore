package br.com.caio.futscore.dto;

import java.util.Date;

import br.com.caio.futscore.model.Partida;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PartidaDTO {

	private Long id;

	private CompeticaoAnoDTO competicaoAno;

	private ClubeDTO clubeMandante;

	private ClubeDTO clubeVisitante;

	private EstadioDTO estadio;

	private ArbitroDTO arbitro;

	private Boolean mandoCampoNeutro;

	private Integer quantidadeTorcedores;
	
	private Integer golsClubeMandante;

	private Integer golsClubeVisitante;
	
	private Date dataPartida;
	
	private Boolean partidaRealizada;

	public PartidaDTO(Partida partida) {

		this.id = partida.getId();
		this.mandoCampoNeutro = partida.getMandoCampoNeutro();
		this.quantidadeTorcedores = partida.getQuantidadeTorcedores();
		this.golsClubeMandante = partida.getGolsClubeMandante();
		this.golsClubeVisitante = partida.getGolsClubeVisitante();
		this.partidaRealizada = partida.getPartidaRealizada();
		this.dataPartida = partida.getDataPartida();

	}

	public PartidaDTO(Long id) {
		this.id = id;
	}
}
