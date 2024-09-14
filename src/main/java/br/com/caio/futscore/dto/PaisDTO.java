package br.com.caio.futscore.dto;

import br.com.caio.futscore.model.Pais;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PaisDTO {

    private Integer id;

    private String nome;

    private ContinenteDTO continente;

    private String imagem;

    public PaisDTO(Pais pais) {

        this.id = pais.getId();
        this.nome = pais.getNome();
        this.continente = new ContinenteDTO(pais.getContinente());
        this.imagem = pais.getImagem();

    }
    
    public PaisDTO(Integer id) {
    	
    	this.id = id;
    	
    }

}
