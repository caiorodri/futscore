package br.com.caio.futscore.dto;

import br.com.caio.futscore.model.Campeonato;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CampeonatoDTO {

    private Long id;

    private CompeticaoAnoDTO competicaoAno;

    private ClubeDTO clube;

    private Integer partidas;

    private Integer vitorias;

    private Integer empates;

    private Integer derrotas;

    private Integer golsFeitos;

    private Integer golsSofridos;

    private Integer punicao;

    public CampeonatoDTO(Campeonato campeonato) {

        this.id = campeonato.getId();
        this.competicaoAno = new CompeticaoAnoDTO(campeonato.getCompeticaoAno());
        this.clube = new ClubeDTO(campeonato.getClube());
        this.partidas = campeonato.getPartidas();
        this.vitorias = campeonato.getVitorias();
        this.empates = campeonato.getEmpates();
        this.derrotas = campeonato.getDerrotas();
        this.golsFeitos = campeonato.getGolsFeitos();
        this.golsSofridos = campeonato.getGolsSofridos();
        this.punicao = campeonato.getPunicao();

    }
	
    public CampeonatoDTO(Long id) {
		this.id = id;
	}
}
