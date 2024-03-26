package br.com.rankanimes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.rankanimes.model.Produto;
import br.com.rankanimes.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller("ProdutoController")
@RequestMapping(value = "/produto")
public class ProdutoController {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Produto>> getAllProducts() {
        List<Produto> produtos = (List<Produto>)this.produtoRepository.findAll();
        return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
    }

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Produto> insertNewProduct(@RequestBody Produto produto) {
        Produto produtoSalvo  = produtoRepository.save(produto);
        return new ResponseEntity(produtoSalvo, HttpStatus.OK);
    }
    
    
}
