package br.com.grupo05.trabalho3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupo05.trabalho3.entity.AlunoEntity;
import br.com.grupo05.trabalho3.service.AlunoDAOImpl;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	private AlunoDAOImpl alunoDAO;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void adicionarAluno(@RequestBody AlunoEntity aluno) {
		alunoDAO.adicionar(aluno);
	}

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AlunoEntity> buscarAluno(@PathVariable("id") Long id) {
		return new ResponseEntity<AlunoEntity>(alunoDAO.buscar(id), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public void removerAluno(@PathVariable("id") Long id) {
		alunoDAO.remover(id);
	}

	@PostMapping(value = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void atualizarAluno(@PathVariable("id") Long id, @RequestBody AlunoEntity aluno) {
		aluno.setId(id);
		alunoDAO.atualizar(aluno);
	}

	@GetMapping
	public ResponseEntity<List<AlunoEntity>> buscarTodosAlunos() {
		return new ResponseEntity<List<AlunoEntity>>(alunoDAO.buscarTodos(), HttpStatus.OK);
	}

	@PostMapping(value = "{idAluno}/disciplina/{idDiscplina}")
	public void adicionarDisciplina(@PathVariable("idAluno") Long idAluno, @PathVariable("idDiscplina") Long idDisciplina) {
		alunoDAO.adicionarDisciplina(idAluno, idDisciplina);
	}

	@DeleteMapping(value = "{idAluno}/disciplina/{idDiscplina}")
	public void removerDisciplina(@PathVariable("idAluno") Long idAluno, @PathVariable("idDiscplina") Long idDisciplina) {
		alunoDAO.removerDisciplina(idAluno, idDisciplina);
	}

	@GetMapping(value = "/nome/{nomeAluno}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AlunoEntity> buscarAlunoPorNome(@PathVariable("nomeAluno") String nome) {
		return new ResponseEntity<AlunoEntity>(alunoDAO.buscarAlunoPorNome(nome), HttpStatus.OK);
	}
	
	@GetMapping(value = "/curso/{cursoAluno}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AlunoEntity> buscarAlunoPorCurso(@PathVariable("cursoAluno") String curso) {
		return new ResponseEntity<AlunoEntity>(alunoDAO.buscarAlunoPorCurso(curso), HttpStatus.OK);
	}
}
