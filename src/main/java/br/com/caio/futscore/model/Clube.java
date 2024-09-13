package br.com.caio.futscore.model;

import java.io.Serializable;
import java.util.Date;

import br.com.caio.futscore.dto.ClubeDTO;
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
@Table(name = "clube")
public class Clube implements Serializable {

	private static final long serialVersionUID = -1076644800302216006L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "pais_id")
	private Pais pais;
	
	@Column(name = "ano_fundacao")
	private Date anoFundacao;
	
	@Column(name = "imagem")
	private String imagem;
	
	public Clube(ClubeDTO clubeDTO) {
		
		this.id = clubeDTO.getId();
		this.nome = clubeDTO.getNome();
		this.pais = new Pais(clubeDTO.getPais());
		this.anoFundacao = clubeDTO.getAnoFundacao();
		this.imagem = clubeDTO.getImagem();
		
	}

	public Clube(Long id) {
		super();
		this.id = id;
	}
	
	
	
}
