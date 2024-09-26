package br.com.caio.futscore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.caio.futscore.model.Pais;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer>{

    @Query("SELECT pais FROM Pais pais " +
           "LEFT JOIN FETCH pais.continente continente " +
           "WHERE continente.id = ?1")
    public List<Pais> findAllByContinenteId(Integer idContinente);
    
    @Query("SELECT pais FROM Pais pais " +
    		"INNER JOIN pais.continente c " +
    		"ORDER BY pais.nome")
    public List<Pais> findAll();
    
}
