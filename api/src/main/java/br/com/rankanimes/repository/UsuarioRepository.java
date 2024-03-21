package br.com.rankanimes.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.rankanimes.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
    
}
