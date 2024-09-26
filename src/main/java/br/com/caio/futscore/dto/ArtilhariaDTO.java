package br.com.caio.futscore.dto;

import br.com.caio.futscore.model.Artilharia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ArtilhariaDTO {

    private Long id;

    private CampeonatoDTO campeonato;

    private JogadorDTO jogador;

    private ClubeDTO clube;

    private Integer gols;

    private Integer assistencias;

    public ArtilhariaDTO(Artilharia artilharia) {

        this.id = artilharia.getId();
        this.gols = artilharia.getGols();
        this.assistencias = artilharia.getAssistencias();
    }


	public ArtilhariaDTO(Long id) {
		this.id = id;
	}
    
}
