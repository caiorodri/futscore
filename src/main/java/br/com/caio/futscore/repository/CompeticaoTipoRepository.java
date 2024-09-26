package br.com.caio.futscore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.caio.futscore.model.CompeticaoTipo;

@Repository
public interface CompeticaoTipoRepository extends JpaRepository<CompeticaoTipo, Integer>{

}
