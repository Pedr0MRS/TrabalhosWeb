package br.com.grupo05.trabalho3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.grupo05.trabalho3.entity.DisciplinaEntity;

@Repository
public interface DisciplinaRepository extends JpaRepository<DisciplinaEntity, Long>{

	public DisciplinaEntity findByNome(String nome);

	public List<DisciplinaEntity> findByNomeContaining(String nome);
	
	public List<DisciplinaEntity> findByOrientadorContaining(String orientador);
}
