package br.com.caio.futscore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.caio.futscore.model.Clube;

@Repository
public interface ClubeRepository extends JpaRepository<Clube, Long>{

	@Query("SELECT clube FROM Clube clube " + 
			"INNER JOIN clube.pais pais " +
			"WHERE pais.id = ?1 " + 
			"ORDER BY clube.nome")
	public List<Clube> findAllByPaisId(Integer idPais);


	@Query("SELECT clube FROM Clube clube " + 
			"INNER JOIN clube.pais pais " +
			"INNER JOIN pais.continente continente " + 
			"WHERE continente.id = ?1 " + 
			"ORDER BY clube.nome")
	public List<Clube> findAllByContinenteId(Integer idContinente);

	
}
