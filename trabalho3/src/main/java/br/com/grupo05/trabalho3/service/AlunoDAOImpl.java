package br.com.grupo05.trabalho3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import br.com.grupo05.trabalho3.dao.AlunoDAO;
import br.com.grupo05.trabalho3.entity.AlunoEntity;
import br.com.grupo05.trabalho3.repository.AlunoRepository;

@Service
@Configurable
public class AlunoDAOImpl implements AlunoDAO {
	
	@Autowired
	private AlunoRepository alunoRepository;

	@Override
	public void adicionarAluno(AlunoEntity aluno) {
		alunoRepository.save(aluno);
	}

	@Override
	public AlunoEntity getAluno(Long id) {
		return null;
	}

	@Override
	public void removerAluno(Long id) {
	}

	@Override
	public void atualizarAluno(AlunoEntity aluno) {
		
	}

	@Override
	public List<AlunoEntity> getTodosAlunos() {
		return null;
	}

}
