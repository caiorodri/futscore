package br.com.caio.futscore.dto;

import br.com.caio.futscore.model.Posicao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PosicaoDTO {

    private Integer id;

    private String nome;
    
    private String sigla;
    
    public PosicaoDTO(Posicao posicao) {
    	
    	this.id = posicao.getId();
    	this.nome = posicao.getNome();
    	this.sigla = posicao.getSigla();

    }
    
}
