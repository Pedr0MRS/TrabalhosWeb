package br.com.grupo05.trabalho3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.grupo05.trabalho3.entity.AlunoEntity;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntity, Long>{

}
