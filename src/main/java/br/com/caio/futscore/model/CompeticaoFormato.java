package br.com.caio.futscore.model;

import java.io.Serializable;

import br.com.caio.futscore.dto.CompeticaoFormatoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "competicao_formato")
public class CompeticaoFormato implements Serializable {

	private static final long serialVersionUID = 1189258030845581444L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome")
	private String nome;

	public CompeticaoFormato(CompeticaoFormatoDTO competicaoFormatoDTO) {

		this.id = competicaoFormatoDTO.getId();
		this.nome = competicaoFormatoDTO.getNome();

	}

	public CompeticaoFormato(Integer id) {
		this.id = id;
	}
	
	

}
