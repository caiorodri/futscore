package br.com.caio.futscore.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.caio.futscore.model.Partida;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long>{

	@Query("SELECT partida FROM Partida partida " + 
			"LEFT JOIN FETCH partida.competicaoAno compAno " +
			"LEFT JOIN FETCH compAno.competicao comp " +
			"INNER JOIN FETCH partida.clubeMandante clubeM " + 
			"INNER JOIN FETCH partida.clubeVisitante clubeV " +
			"INNER JOIN FETCH partida.arbitro arbitro " + 
			"INNER JOIN FETCH partida.estadio estadio " +
			"WHERE partida.id = ?1")
	public Optional<Partida> findById(Long id);
	
	@Query("SELECT partida FROM Partida partida " + 
			"LEFT JOIN FETCH partida.competicaoAno compAno " +
			"INNER JOIN FETCH partida.clubeMandante clubeM " + 
			"INNER JOIN FETCH partida.clubeVisitante clubeV " +
			"INNER JOIN FETCH partida.arbitro arbitro " + 
			"INNER JOIN FETCH partida.estadio estadio " + 
			"ORDER BY partida.dataPartida")
	public List<Partida> findAll();
	
	@Query("SELECT partida FROM Partida partida " +
			"LEFT JOIN FETCH partida.competicaoAno competicaoAno " +
			"INNER JOIN FETCH partida.clubeMandante clubeM " + 
			"INNER JOIN FETCH partida.clubeVisitante clubeV " +
			"INNER JOIN FETCH partida.arbitro arbitro " + 
			"INNER JOIN FETCH partida.estadio estadio " +
			"WHERE competicaoAno.id = ?1")
	public List<Partida> findAllByCompeticaoAnoId(Long idCompeticaoAno);
	

	@Query("SELECT partida FROM Partida partida " +
			"LEFT JOIN FETCH partida.competicaoAno competicaoAno " +
           "WHERE competicaoAno.id = ?1 AND partida.dataPartida > ?2 AND partida.dataPartida < ?3")
    public List<Partida> findAllByCompeticaoAnoAndDia(Long idCompeticaoAno, Date diaInicio, Date diaFim);
}
