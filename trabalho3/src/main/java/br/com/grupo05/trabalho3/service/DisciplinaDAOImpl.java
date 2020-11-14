package br.com.grupo05.trabalho3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grupo05.trabalho3.dao.CrudDAO;
import br.com.grupo05.trabalho3.entity.DisciplinaEntity;
import br.com.grupo05.trabalho3.repository.DisciplinaRepository;

@Service
public class DisciplinaDAOImpl implements CrudDAO<DisciplinaEntity> {

	@Autowired
	private DisciplinaRepository repository;

	@Override
	public void adicionar(DisciplinaEntity entidade) {
		repository.save(entidade);
	}

	@Override
	public DisciplinaEntity buscar(Long id) {
		Optional<DisciplinaEntity> disciplina = repository.findById(id);
		if (disciplina.isPresent()) {
			return disciplina.get();
		}
		return null;
	}

	@Override
	public void remover(Long id) {
		
	}

	@Override
	public void atualizar(DisciplinaEntity entidade) {
		
	}

	@Override
	public List<DisciplinaEntity> buscarTodos() {
		return null;
	}
	
	
}
