package br.com.caio.futscore.model;

import java.io.Serializable;
import java.util.Date;

import br.com.caio.futscore.dto.JogadorDTO;
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
public class Jogador implements Serializable {

	private static final long serialVersionUID = 1104024675122407877L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	@ManyToOne
	@JoinColumn(name = "clube_atual_id")
	private Clube clubeAtual;

	@ManyToOne
	@JoinColumn(name = "nacionalidade")
	private Pais nacionalidade;

	@Column(name = "data_nascimento")
	private Date dataNascimento;

	private Integer jogos;

	private Integer gols;

	private Integer assistencias;

	@Column(name = "cartoes_amarelo")
	private Integer cartoesAmarelo;

	@Column(name = "cartoes_vermelho")
	private Integer cartoesVermelho;

	@Column(name = "valor_mercado")
	private Double valorMercado;

	private String imagem;

	public Jogador(JogadorDTO jogadorDTO) {

		this.id = jogadorDTO.getId();
		this.nome = jogadorDTO.getNome();
		this.clubeAtual = new Clube(jogadorDTO.getClubeAtual());
		this.nacionalidade = new Pais(jogadorDTO.getNacionalidade());
		this.dataNascimento = jogadorDTO.getDataNascimento();
		this.jogos = jogadorDTO.getJogos();
		this.gols = jogadorDTO.getGols();
		this.assistencias = jogadorDTO.getAssistencias();
		this.cartoesAmarelo = jogadorDTO.getCartoesAmarelo();
		this.cartoesVermelho = jogadorDTO.getCartoesVermelho();
		this.valorMercado = jogadorDTO.getValorMercado();
		this.imagem = jogadorDTO.getImagem();

	}

	public Jogador(Long id) {
		this.id = id;
	}
	
	

}
