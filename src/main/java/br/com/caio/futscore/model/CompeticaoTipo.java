package br.com.caio.futscore.model;

import java.io.Serializable;

import br.com.caio.futscore.dto.CompeticaoTipoDTO;
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
@Table(name = "competicao_tipo")
public class CompeticaoTipo implements Serializable {

	private static final long serialVersionUID = 5329129317627243794L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome")
	private String nome;

	public CompeticaoTipo(CompeticaoTipoDTO competicaoTipoDTO) {

		this.id = competicaoTipoDTO.getId();
		this.nome = competicaoTipoDTO.getNome();

	}

	public CompeticaoTipo(Integer id) {
		this.id = id;
	}
	
	
}
