package br.com.grupo05.trabalho3.dao;

import java.util.List;

import br.com.grupo05.trabalho3.entity.AlunoEntity;

public interface AlunoDAO {
	
	public void adicionarAluno(AlunoEntity aluno);
	
	public AlunoEntity getAluno(Long id);
	
	public void removerAluno(Long id);
	
	public void atualizarAluno(AlunoEntity aluno);
	
	public List<AlunoEntity> getTodosAlunos();
}
