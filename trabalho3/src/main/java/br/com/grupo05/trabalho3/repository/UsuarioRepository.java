package br.com.grupo05.trabalho3.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.grupo05.trabalho3.entity.UsuarioEntity;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<UsuarioEntity, Long>{

	UsuarioEntity findByUsuario(String usuario);
}
