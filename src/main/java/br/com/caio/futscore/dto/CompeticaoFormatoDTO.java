package br.com.caio.futscore.dto;

import br.com.caio.futscore.model.CompeticaoFormato;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CompeticaoFormatoDTO {

    private Integer id;

    private String nome;

    public CompeticaoFormatoDTO(CompeticaoFormato competicaoFormato) {

        this.id = competicaoFormato.getId();
        this.nome = competicaoFormato.getNome();

    }
    
    public CompeticaoFormatoDTO(Integer id) {
		this.id = id;
	}

}
