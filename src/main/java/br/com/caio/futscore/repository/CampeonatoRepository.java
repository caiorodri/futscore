package br.com.caio.futscore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.caio.futscore.model.Campeonato;
import br.com.caio.futscore.model.Clube;

@Repository
public interface CampeonatoRepository extends JpaRepository<Campeonato, Long>{

	@Query("SELECT clube FROM Campeonato camp " + 
			"INNER JOIN camp.clube clube " + 
			"INNER JOIN camp.competicaoAno compAno " +
			"WHERE compAno.id = ?1 " +
			"ORDER BY clube.nome")
	public List<Clube> findAllClubesByCompeticaoAno(Long idCompeticaoAno);
	
}
