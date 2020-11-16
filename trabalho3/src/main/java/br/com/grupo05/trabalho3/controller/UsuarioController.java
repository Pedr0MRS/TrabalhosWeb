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

import br.com.grupo05.trabalho3.entity.UsuarioEntity;
import br.com.grupo05.trabalho3.service.UsuarioDAOImpl;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioDAOImpl usuarioDAO;
	
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	@PreAuthorize("hasRole('ADMIN')")
	public void adicionarUsuario(@RequestBody UsuarioEntity usuario) {
		usuarioDAO.adicionar(usuario);
	}
	
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<UsuarioEntity> buscarUsuario(@PathVariable("id") Long id) {
		return new ResponseEntity<UsuarioEntity>(usuarioDAO.buscar(id), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void removerUsuario(@PathVariable("id") Long id) {
		usuarioDAO.remover(id);
	}

	@PutMapping(value = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
	@PreAuthorize("hasRole('ADMIN')")
	public void atualizarUsuario(@PathVariable("id") Long id, @RequestBody UsuarioEntity usuario) {
		usuario.setId(id);
		usuarioDAO.atualizar(usuario);
	}

	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<UsuarioEntity>> buscarTodosUsuarios() {
		return new ResponseEntity<List<UsuarioEntity>>(usuarioDAO.buscarTodos(), HttpStatus.OK);
	}
}
