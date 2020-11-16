package br.com.grupo05.trabalho3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grupo05.trabalho3.dao.CrudDAO;
import br.com.grupo05.trabalho3.entity.DisciplinaEntity;
import br.com.grupo05.trabalho3.error.BadRequestException;
import br.com.grupo05.trabalho3.error.ResourceNotFoundException;
import br.com.grupo05.trabalho3.repository.DisciplinaRepository;

@Service
public class DisciplinaDAOImpl implements CrudDAO<DisciplinaEntity> {

	@Autowired
	private DisciplinaRepository repository;

	@Override
	public void adicionar(DisciplinaEntity entidade) {
		validaCamposDisciplina(entidade);
		repository.save(entidade);
	}

	@Override
	public DisciplinaEntity buscar(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado disciplina com id=" + id));
	}

	@Override
	public void remover(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void atualizar(DisciplinaEntity entidade) {
		buscar(entidade.getId());
		validaCamposDisciplina(entidade);
		repository.save(entidade);
	}

	@Override
	public List<DisciplinaEntity> buscarTodos() {
		return (List<DisciplinaEntity>) repository.findAll();
	}
	
	public List<DisciplinaEntity> buscarDisciplinasPorNome(String nome){
		return repository.findByNomeContaining(nome);
	}

	public List<DisciplinaEntity> buscarDisciplinasPorOrientador(String orientador){
		return repository.findByOrientadorContaining(orientador);
	}
	
	private void validaCamposDisciplina(DisciplinaEntity disciplina) {
		if (disciplina.getNome() == null || disciplina.getNome().isEmpty()) {
			throw new BadRequestException("É necessário preencher campo nome");
		}
		if (disciplina.getOrientador() == null || disciplina.getOrientador().isEmpty()) {
			throw new BadRequestException("É necessário preencher campo orientador");
		}
		if (disciplina.getCreditos() <= 0) {
			throw new BadRequestException("Número de créditos deve ser maior que 0");
		}
		if (disciplina.getNome().length() > 50) {
			throw new BadRequestException("O número máximo de caracteres do campo nome é (50)");
		}
		if (disciplina.getOrientador().length() > 100) {
			throw new BadRequestException("O número máximo de caracteres do campo orientador é (100)");
		}
		DisciplinaEntity disciplinaByNome = repository.findByNome(disciplina.getNome());
		if (disciplinaByNome != null && disciplinaByNome.getId() != disciplina.getId()) {
			throw new BadRequestException("Já existe disciplina com esse nome");
		}
	}
}
