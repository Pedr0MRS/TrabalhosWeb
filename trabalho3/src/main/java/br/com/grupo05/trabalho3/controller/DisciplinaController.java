package br.com.grupo05.trabalho3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupo05.trabalho3.entity.DisciplinaEntity;
import br.com.grupo05.trabalho3.service.DisciplinaDAOImpl;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {
	
	@Autowired
	private DisciplinaDAOImpl disciplinaDAO;
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
	@PreAuthorize("hasRole('ADMIN')")
	public void adicionarDisciplina(@RequestBody DisciplinaEntity disciplina) {
		disciplinaDAO.adicionar(disciplina);
	}
	
	@GetMapping(value= "/{id}",
			    produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<DisciplinaEntity> buscarDisciplina(@PathVariable("id") Long id) {
		return  new ResponseEntity<DisciplinaEntity>(disciplinaDAO.buscar(id), HttpStatus.OK);
	}
	
	@DeleteMapping(value= "/{id}")
	public void removerDisciplina(@PathVariable("id") long id) {
		buscarDisciplina(id);
		disciplinaDAO.remover(id);
	}
	
	@PutMapping(value="/{id}",
				consumes = {MediaType.APPLICATION_JSON_VALUE})
	@PreAuthorize("hasRole('ADMIN')")
	public void atualizarDisciplina(@PathVariable("id") long id, @RequestBody DisciplinaEntity disciplina){
		disciplina.setId(id);
		disciplinaDAO.atualizar(disciplina);
	}
	
	@GetMapping
	public ResponseEntity<List<DisciplinaEntity>> buscarTodasDisciplinas() {
		return new ResponseEntity<List<DisciplinaEntity>>(disciplinaDAO.buscarTodos(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/nome/{nomeDisciplina}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<DisciplinaEntity>> buscarAlunosPorNome(@PathVariable("nomeDisciplina") String nome) {
		return new ResponseEntity<List<DisciplinaEntity>>(disciplinaDAO.buscarDisciplinasPorNome(nome), HttpStatus.OK);
	}
	
	@GetMapping(value = "/orientador/{orientadorDisciplina}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<DisciplinaEntity>> buscarAlunosPorCurso(@PathVariable("orientadorDisciplina") String orientador) {
		return new ResponseEntity<List<DisciplinaEntity>>(disciplinaDAO.buscarDisciplinasPorOrientador(orientador), HttpStatus.OK);
	}
}
