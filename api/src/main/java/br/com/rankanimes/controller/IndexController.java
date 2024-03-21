package br.com.rankanimes.controller;

import java.net.http.HttpTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.rankanimes.model.Usuario;
import br.com.rankanimes.repository.UsuarioRepository;

@RestController("IndexController")
@RequestMapping("/usuario")
public class IndexController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping(value = "/endpoint1", produces = "application/json")
    public ResponseEntity init(@RequestParam(value = "nome", defaultValue = "none")String nome, @RequestParam(value = "nome2", defaultValue = "none2")String nome2){
        return new ResponseEntity("Olá mundo: " + nome + ' ' + nome2, HttpStatus.OK);    
    }
    
    @GetMapping(value = "/endpoint2", produces = "application/json")
    public ResponseEntity<Usuario> init2(){
        Usuario usuario1 = new Usuario();
        usuario1.setId(1L);
        usuario1.setNome("leandro");
        
        return new ResponseEntity<>(usuario1,HttpStatus.OK);
    }

    @GetMapping(value = "/usuarios", produces = "application/json")
    public ResponseEntity init3() {

        List<Usuario> list = (List<Usuario>)usuarioRepository.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);

    }
    
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Usuario> init4(@PathVariable(value="id")Long id){
        try{
            Optional <Usuario> usuario = usuarioRepository.findById(id);
            return new ResponseEntity(usuario.get(), HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity("no such user", HttpStatus.NOT_FOUND);
        }
     }
       
     @PostMapping(value = "/", produces = "application/json")
     public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario){
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.OK);
     }

     @PutMapping(value = "/", produces = "application/json")
     public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario){
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.OK);
     }

     @DeleteMapping(value = "/{id}", produces = "application/text")
     public String deletar(@PathVariable Long id){
        usuarioRepository.deleteById(id);
        return "ok";
     }

}
