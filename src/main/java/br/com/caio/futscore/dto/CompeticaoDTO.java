package br.com.caio.futscore.dto;

import br.com.caio.futscore.model.Competicao;
import java.util.List;
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
        
    private List<CompeticaoAnoDTO> competicoesAno;

	public CompeticaoDTO(Competicao competicao) {

		this.id = competicao.getId();
		this.nome = competicao.getNome();
		this.imagem = competicao.getImagem();

	}

	public CompeticaoDTO(Long id) {
		this.id = id;
	}

}
