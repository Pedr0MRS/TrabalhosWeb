package br.com.grupo05.trabalho3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
	public void adicionarAluno(@RequestBody AlunoEntity aluno) {
		alunoDAO.adicionar(aluno);
	}
	
	@GetMapping(value= "/{id}",
			    consumes = {MediaType.APPLICATION_JSON_VALUE},
			    produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<AlunoEntity> buscarAluno(@PathVariable("id") Long id) {
		return  new ResponseEntity<AlunoEntity>(alunoDAO.buscar(id), HttpStatus.ACCEPTED);
	}

}
