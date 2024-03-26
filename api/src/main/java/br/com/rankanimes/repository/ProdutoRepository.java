package br.com.rankanimes.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.rankanimes.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long>{
    
}
