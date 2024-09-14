package br.com.caio.futscore.model;

import java.io.Serializable;

import br.com.caio.futscore.dto.CompeticaoAnoDTO;
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
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
public class CompeticaoAno implements Serializable {

	private static final long serialVersionUID = 1043528869222649345L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "formato_id")
	private CompeticaoFormato formatoCompeticao;
	
	@Column(name = "quantidade_clubes")
	private Integer quantidadeClubes;
	
	private Integer ano;
	
	@Column(name = "pontuacao_vitoria")
	private Integer pontuacaoVitoria;

	@Column(name = "pontuacao_empate")
	private Integer pontuacaoEmpate;

	@Column(name = "pontuacao_derrota")
	private Integer pontuacaoDerrota;

	public CompeticaoAno(CompeticaoAnoDTO competicaoAnoDTO) {
	    this.id = competicaoAnoDTO.getId();
	    this.formatoCompeticao = new CompeticaoFormato(competicaoAnoDTO.getFormatoCompeticao());
	    this.quantidadeClubes = competicaoAnoDTO.getQuantidadeClubes();
	    this.ano = competicaoAnoDTO.getAno();
	    this.pontuacaoVitoria = competicaoAnoDTO.getPontuacaoVitoria();
	    this.pontuacaoEmpate = competicaoAnoDTO.getPontuacaoEmpate();
	    this.pontuacaoDerrota = competicaoAnoDTO.getPontuacaoDerrota();
	}

	public CompeticaoAno(Long id) {
		this.id = id;
	}
	
	
}
