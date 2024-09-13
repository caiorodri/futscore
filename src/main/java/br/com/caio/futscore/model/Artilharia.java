package br.com.caio.futscore.model;

import java.io.Serializable;

import br.com.caio.futscore.dto.ArtilhariaDTO;
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
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "artilharia")
public class Artilharia implements Serializable {

	private static final long serialVersionUID = -1473067753892581942L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne()
	@JoinColumn(name = "campeonato_id")
	private Campeonato campeonato;
	
	@ManyToOne()
	@JoinColumn(name = "jogador_id")
	private Jogador jogador;
	
	@ManyToOne()
	@JoinColumn(name = "clube_id")
	private Clube clube;
	
	@Column(name = "gols")
	private int gols;
	
	@Column(name = "assistencias")
	private int assistencias;
	
	public Artilharia(ArtilhariaDTO artilhariaDTO) {
		
		this.id = artilhariaDTO.getId();
		this.campeonato = new Campeonato(artilhariaDTO.getCampeonato());
		this.jogador = new Jogador(artilhariaDTO.getJogador());
		this.clube = new Clube(artilhariaDTO.getClube());
		this.gols = artilhariaDTO.getGols();
		this.assistencias = artilhariaDTO.getAssistencias();
		
	}
	
}
