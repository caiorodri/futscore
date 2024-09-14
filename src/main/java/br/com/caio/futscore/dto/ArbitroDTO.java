package br.com.caio.futscore.dto;

import br.com.caio.futscore.model.Arbitro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ArbitroDTO {

    private Long id;

    private String nome;

    private Integer partidas;

    private Integer cartoesVermelho;

    private Integer cartoesAmarelo;

    public ArbitroDTO(Arbitro arbitro) {

        this.id = arbitro.getId();
        this.nome = arbitro.getNome();
        this.partidas = arbitro.getPartidas();
        this.cartoesAmarelo = arbitro.getCartoesAmarelo();
        this.cartoesVermelho = arbitro.getCartoesVermelho();

    }

	public ArbitroDTO(Long id) {
		this.id = id;
	}
    
}
