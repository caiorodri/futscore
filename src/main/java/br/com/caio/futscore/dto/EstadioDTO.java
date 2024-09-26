package br.com.caio.futscore.dto;

import java.util.List;

import br.com.caio.futscore.model.Estadio;
import br.com.caio.futscore.model.Partida;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class EstadioDTO {

    private Long id;

    private String nome;

    private PaisDTO pais;

    private Integer capacidade;
    
    private List<Partida> partidas;

    public EstadioDTO(Estadio estadio) {

        this.id = estadio.getId();
        this.nome = estadio.getNome();
        this.capacidade = estadio.getCapacidade();

    }
    
    
    public EstadioDTO(Long id) {
		this.id = id;
	}
}
