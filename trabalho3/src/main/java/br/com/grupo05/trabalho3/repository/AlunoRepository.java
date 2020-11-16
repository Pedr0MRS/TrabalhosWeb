package br.com.grupo05.trabalho3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.grupo05.trabalho3.entity.AlunoEntity;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntity, Long>{

	public List<AlunoEntity> findByNomeContaining(String nome);
	
	public List<AlunoEntity> findByCursoContaining(String curso);
	
	public AlunoEntity findByMatricula(String matricula);
}
