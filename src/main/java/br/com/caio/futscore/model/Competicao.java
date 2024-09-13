package br.com.caio.futscore.model;

import java.io.Serializable;

import br.com.caio.futscore.dto.CompeticaoDTO;
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
public class Competicao implements Serializable {

	private static final long serialVersionUID = 7956468628029288839L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "competicao_tipo_id")
	private CompeticaoTipo competicaoTipo;
	
	@ManyToOne
	@JoinColumn(name = "pais_id")
	private Pais pais;
	
	private String imagem;

	public Competicao(CompeticaoDTO competicaoDTO) {

		this.id = competicaoDTO.getId();
		this.nome = competicaoDTO.getNome();
		this.competicaoTipo = new CompeticaoTipo(competicaoDTO.getCompeticaoTipo());
		this.pais = new Pais(competicaoDTO.getPais());
		this.imagem = competicaoDTO.getImagem();
	}

	public Competicao(Long id) {
		this.id = id;
	}
	
	
	
}
