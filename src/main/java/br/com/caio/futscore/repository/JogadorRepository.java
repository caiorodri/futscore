package br.com.caio.futscore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.caio.futscore.model.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long>{

	@Query("SELECT jogador FROM Jogador jogador " +
			"LEFT JOIN FETCH jogador.nacionalidade nac " + 
			"LEFT JOIN FETCH jogador.clubeAtual clube " +
			"LEFT JOIN FETCH clube.pais clubePais " +
			"LEFT JOIN FETCH jogador.posicao " + 
			"WHERE jogador.id = ?1")
	public Optional<Jogador> findById(Long id);
	

	@Query("SELECT jogador FROM Jogador jogador " +
			"INNER JOIN FETCH jogador.nacionalidade nac " + 
			"INNER JOIN FETCH jogador.clubeAtual clube " +
			"INNER JOIN FETCH jogador.posicao " + 
			"ORDER BY jogador.nome")
	public List<Jogador> findAllJogador();
}
