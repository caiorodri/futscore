package br.com.caio.futscore.model;

import java.io.Serializable;

import br.com.caio.futscore.dto.ContinenteDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "continente")
public class Continente implements Serializable {

    private static final long serialVersionUID = 7758078196099763926L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    public Continente(ContinenteDTO continenteDTO) {

        this.id = continenteDTO.getId();
        this.nome = continenteDTO.getNome();

    }

}

