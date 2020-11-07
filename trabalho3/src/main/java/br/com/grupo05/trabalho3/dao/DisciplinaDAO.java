package br.com.grupo05.trabalho3.dao;

import java.util.List;

import br.com.grupo05.trabalho3.entity.DisciplinaEntity;

public interface DisciplinaDAO {
	
	public void adicionarDisciplina(DisciplinaEntity aluno);
	
	public DisciplinaEntity getDisciplina(Long id);
	
	public void removerDisciplina(Long id);
	
	public void atualizarDisciplina(DisciplinaEntity aluno);
	
	public List<DisciplinaEntity> getTodosAlunos();
}
