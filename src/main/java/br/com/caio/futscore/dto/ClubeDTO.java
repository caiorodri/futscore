package br.com.caio.futscore.dto;

import java.util.Date;
import java.util.List;

import br.com.caio.futscore.model.Clube;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ClubeDTO {

    private Long id;

    private String nome;

    private PaisDTO pais;

    private Date anoFundacao;

    private String imagem;
    
    private List<JogadorDTO> jogadores;
    
    private List<PartidaDTO> partidasRealizadas;

    private List<PartidaDTO> proximasPartidas;

    public ClubeDTO(Clube clube) {

        this.id = clube.getId();
        this.nome = clube.getNome();
        this.anoFundacao = clube.getAnoFundacao();
        this.imagem = clube.getImagem();

    }

	
    public ClubeDTO(Long id) {
		this.id = id;
	}
}
