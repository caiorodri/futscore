package br.com.caio.futscore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.caio.futscore.model.Artilharia;

@Repository
public interface ArtilhariaRepository extends JpaRepository<Artilharia, Long>{

}
