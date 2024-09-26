package br.com.caio.futscore.model;

import java.io.Serializable;

import br.com.caio.futscore.dto.PosicaoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Posicao implements Serializable{
	  
	private static final long serialVersionUID = 4028023235498420109L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	
	private String sigla;
	
    public Posicao(PosicaoDTO posicaoDTO) {
    	
    	this.id = posicaoDTO.getId();
    	this.nome = posicaoDTO.getNome();
    	this.sigla = posicaoDTO.getSigla();

    }
    
}
