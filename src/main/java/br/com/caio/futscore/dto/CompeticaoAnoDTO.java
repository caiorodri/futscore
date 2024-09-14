package br.com.caio.futscore.dto;

import br.com.caio.futscore.model.CompeticaoAno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CompeticaoAnoDTO {

    private Long id;

    private CompeticaoFormatoDTO formatoCompeticao;

    private Integer quantidadeClubes;
	
    private Integer ano;

    private Integer pontuacaoVitoria;

    private Integer pontuacaoEmpate;

    private Integer pontuacaoDerrota;

    public CompeticaoAnoDTO(CompeticaoAno competicaoAno) {

        this.id = competicaoAno.getId();	
        this.formatoCompeticao = new CompeticaoFormatoDTO(competicaoAno.getFormatoCompeticao());
        this.quantidadeClubes = competicaoAno.getQuantidadeClubes();
        this.ano = competicaoAno.getAno();
        this.pontuacaoVitoria = competicaoAno.getPontuacaoVitoria();
        this.pontuacaoEmpate = competicaoAno.getPontuacaoEmpate();
        this.pontuacaoDerrota = competicaoAno.getPontuacaoDerrota();
    }


    public CompeticaoAnoDTO(Long id) {
		this.id = id;
	}
}
