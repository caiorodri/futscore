package br.com.caio.futscore.model;

import java.io.Serializable;

import br.com.caio.futscore.dto.CampeonatoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "campeonato")
public class Campeonato implements Serializable {

	private static final long serialVersionUID = 3431553899873381773L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "competicao_ano_id")
	private CompeticaoAno competicaoAno;
	
	@ManyToOne
	@JoinColumn(name = "clube_id")
	private Clube clube;
	
	@Column(name = "partidas")
	private Integer partidas;

	@Column(name = "vitorias")
	private Integer vitorias;

	@Column(name = "empates")
	private Integer empates;

	@Column(name = "derrotas")
	private Integer derrotas;

	@Column(name = "gols_feito")
	private Integer golsFeitos;

	@Column(name = "gols_sofrido")
	private Integer golsSofridos;
	
	@Column(name = "punicao")
	private Integer punicao;
	
	public Campeonato(CampeonatoDTO campeonatoDTO) {
		
		this.id = campeonatoDTO.getId();
		this.partidas = campeonatoDTO.getPartidas();
		this.vitorias = campeonatoDTO.getVitorias();
		this.empates = campeonatoDTO.getEmpates();
		this.derrotas = campeonatoDTO.getDerrotas();
		this.golsFeitos = campeonatoDTO.getGolsFeitos();
		this.golsSofridos = campeonatoDTO.getGolsSofridos();
		this.punicao = campeonatoDTO.getPunicao();
		
	}

	public Campeonato(Long id) {
		this.id = id;
	}

	
	
}
