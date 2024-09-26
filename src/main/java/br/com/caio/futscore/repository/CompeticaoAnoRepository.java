package br.com.caio.futscore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.caio.futscore.model.CompeticaoAno;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface CompeticaoAnoRepository extends JpaRepository<CompeticaoAno, Long>{
    

    @Query("SELECT competicaoAno FROM CompeticaoAno competicaoAno " +
           "LEFT JOIN FETCH competicaoAno.competicao competicao " +
           "WHERE competicao.id = ?1")
    public List<CompeticaoAno> findAllCompeticaoAnoByCompeticaoId(Long idCompeticao);
    
}
