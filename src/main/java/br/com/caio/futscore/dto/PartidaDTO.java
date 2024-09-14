package br.com.caio.futscore.dto;

import br.com.caio.futscore.model.Partida;
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

	public PartidaDTO(Partida partida) {

		this.id = partida.getId();
		this.competicaoAno = new CompeticaoAnoDTO(partida.getCompeticaoAno());
		this.clubeMandante = new ClubeDTO(partida.getClubeMandante());
		this.clubeVisitante = new ClubeDTO(partida.getClubeVisitante());
		this.estadio = new EstadioDTO(partida.getEstadio());
		this.arbitro = new ArbitroDTO(partida.getArbitro());
		this.mandoCampoNeutro = partida.getMandoCampoNeutro();
		this.quantidadeTorcedores = partida.getQuantidadeTorcedores();

	}

	public PartidaDTO(Long id) {
		this.id = id;
	}
}
