package br.com.caio.futscore.dto;

import java.util.Date;
import java.util.List;

import br.com.caio.futscore.model.Jogador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class JogadorDTO {

    private Long id;

    private String nome;

    private ClubeDTO clubeAtual;

    private PaisDTO nacionalidade;

    private Date dataNascimento;

	private PosicaoDTO posicao;

    private Integer jogos;

    private Integer gols;

    private Integer assistencias;

    private Integer cartoesAmarelo;

    private Integer cartoesVermelho;

    private Double valorMercado;

    private String imagem;
    
    private List<ClubeDTO> clubes;
    
    private List<PartidaDTO> partidasRealizadas;

    public JogadorDTO(Jogador jogador) {

        this.id = jogador.getId();
        this.nome = jogador.getNome();
        this.dataNascimento = jogador.getDataNascimento();
        this.jogos = jogador.getJogos();
        this.gols = jogador.getGols();
        this.assistencias = jogador.getAssistencias();
        this.cartoesAmarelo = jogador.getCartoesAmarelo();
        this.cartoesVermelho = jogador.getCartoesVermelho();
        this.valorMercado = jogador.getValorMercado();
        this.imagem = jogador.getImagem();

    }
    
    
    public JogadorDTO(Long id) {
		this.id = id;
	}

}
