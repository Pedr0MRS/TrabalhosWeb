package br.com.grupo05.trabalho3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.grupo05.trabalho3.dao.CrudDAO;
import br.com.grupo05.trabalho3.entity.UsuarioEntity;
import br.com.grupo05.trabalho3.error.BadRequestException;
import br.com.grupo05.trabalho3.error.ResourceNotFoundException;
import br.com.grupo05.trabalho3.repository.UsuarioRepository;

@Service
public class UsuarioDAOImpl implements UserDetailsService, CrudDAO<UsuarioEntity>{

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioEntity usuario = Optional.ofNullable(repository.findByUsuario(username)).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
		List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER","ROLE_ADMIN");
		List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
		return new User(usuario.getUsuario(), usuario.getSenha(), usuario.isAdmin() ? authorityListAdmin : authorityListUser);
	}

	@Override
	public void adicionar(UsuarioEntity entidade) {
		validaCamposUsuario(entidade);
		entidade.setSenha(encriptarSenha(entidade.getSenha()));
		repository.save(entidade);
	}

	@Override
	public UsuarioEntity buscar(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado usuário com id=" + id));
	}

	@Override
	public void remover(Long id) {
		buscar(id);
		repository.deleteById(id);
	}

	@Override
	public void atualizar(UsuarioEntity entidade) {
		buscar(entidade.getId());
		validaCamposUsuario(entidade);
		entidade.setSenha(encriptarSenha(entidade.getSenha()));
		repository.save(entidade);
	}

	@Override
	public List<UsuarioEntity> buscarTodos() {
		return (List<UsuarioEntity>) repository.findAll();
	}
	
	private String encriptarSenha(String senha) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(senha);
	}

	private void validaCamposUsuario(UsuarioEntity usuario) {
		if (usuario.getUsuario() == null || usuario.getNome().isEmpty()) {
			throw new BadRequestException("É necessário preencher campo usuario");
		}
		if (usuario.getSenha() == null || usuario.getSenha().isEmpty() ) {
			throw new BadRequestException("É necessário preencher campo senha");
		}
		if (usuario.getNome() == null || usuario.getNome().isEmpty() ) {
			throw new BadRequestException("É necessário preencher campo nome");
		}
		if (usuario.getUsuario().length() > 50) {
			throw new BadRequestException("O número máximo de caracteres do campo usuario é (50)");
		}
		if (usuario.getSenha().length() > 20) {
			throw new BadRequestException("O número máximo de caracteres do campo senha é (20)");
		}
		if (usuario.getNome().length() > 50) {
			throw new BadRequestException("O número máximo de caracteres do campo nome é (50)");
		}
		UsuarioEntity usuarioByUsuario = repository.findByUsuario(usuario.getUsuario());
		if (usuarioByUsuario != null && usuarioByUsuario.getId() != usuario.getId()) {
			throw new BadRequestException("Já existe usuário com esse nome de usuario");
		}
	}
}
