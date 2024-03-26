package br.com.rankanimes.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.rankanimes.model.Usuario;
import java.util.List;


public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
    @Query("select u from Usuario u where u.login = ?1")
    Usuario findByLogin(String login);
}
