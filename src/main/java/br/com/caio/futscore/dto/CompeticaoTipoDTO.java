package br.com.caio.futscore.dto;

import br.com.caio.futscore.model.CompeticaoTipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CompeticaoTipoDTO {

    private Integer id;

    private String nome;

    public CompeticaoTipoDTO(CompeticaoTipo competicaoTipo) {

        this.id = competicaoTipo.getId();
        this.nome = competicaoTipo.getNome();

    }
    
    public CompeticaoTipoDTO(Integer id) {
		this.id = id;
	}

}
