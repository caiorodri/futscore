package br.com.caio.futscore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.caio.futscore.model.Competicao;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface CompeticaoRepository extends JpaRepository<Competicao, Long>{

    @Query("SELECT c FROM Competicao c " +
           "INNER JOIN FETCH c.pais p " +
           "WHERE p.id = ?1")
    public List<Competicao> findAllByPaisId(Integer idPais);
    
}
