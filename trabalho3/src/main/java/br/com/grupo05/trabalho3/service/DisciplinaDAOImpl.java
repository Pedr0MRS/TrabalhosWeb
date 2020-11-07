package br.com.grupo05.trabalho3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grupo05.trabalho3.dao.DisciplinaDAO;
import br.com.grupo05.trabalho3.entity.DisciplinaEntity;
import br.com.grupo05.trabalho3.repository.DisciplinaRepository;

@Service
public class DisciplinaDAOImpl implements DisciplinaDAO {

	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Override
	public void adicionarDisciplina(DisciplinaEntity aluno) {
		disciplinaRepository.save(aluno);
	}

	@Override
	public DisciplinaEntity getDisciplina(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removerDisciplina(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarDisciplina(DisciplinaEntity aluno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DisciplinaEntity> getTodosAlunos() {
		// TODO Auto-generated method stub
		return null;
	}

}
