package br.com.caio.futscore.dto;

import java.util.List;

import br.com.caio.futscore.model.Continente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ContinenteDTO {

    private Integer id;

    private String nome;
    
    private List<PaisDTO> paises;

    public ContinenteDTO(Continente continente) {

        this.id = continente.getId();
        this.nome = continente.getNome();

    }
    
    public ContinenteDTO(Integer id) {
    	
    	this.id = id;
    	
    }


}
