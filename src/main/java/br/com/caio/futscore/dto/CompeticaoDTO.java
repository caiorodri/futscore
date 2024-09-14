package br.com.caio.futscore.dto;

import br.com.caio.futscore.model.Competicao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CompeticaoDTO {

	private Long id;

	private String nome;

	private CompeticaoTipoDTO competicaoTipo;

	private PaisDTO pais;

	private String imagem;

	public CompeticaoDTO(Competicao competicao) {

		this.id = competicao.getId();
		this.nome = competicao.getNome();
		this.competicaoTipo = new CompeticaoTipoDTO(competicao.getCompeticaoTipo());
		this.pais = new PaisDTO(competicao.getPais());
		this.imagem = competicao.getImagem();

	}

	public CompeticaoDTO(Long id) {
		this.id = id;
	}

}
