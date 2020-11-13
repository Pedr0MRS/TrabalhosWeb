package br.com.grupo05.trabalho3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.grupo05.trabalho3.entity.AlunoEntity;

@Repository
public interface AlunoRepository extends CrudRepository<AlunoEntity, Long>{
}
