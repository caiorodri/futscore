package br.com.caio.futscore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caio.futscore.model.Posicao;

public interface PosicaoRepository extends JpaRepository<Posicao, Integer>{

}
