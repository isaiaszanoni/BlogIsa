package com.isaBlog.isaBlog.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isaBlog.isaBlog.modelos.Postagem;
import com.isaBlog.isaBlog.repositorios.PostagemRepositorio;

@RestController
@RequestMapping("/api/v0-1/postagem")
@CrossOrigin("*")
public class PostagemControlador {
	
	private @Autowired PostagemRepositorio repositorio;
	
	
	@GetMapping("/todas")
	public List<Postagem> PegaTodes(){
		return repositorio.findAll();
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> GetById(@PathVariable Long id){
		return repositorio.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity <Object> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repositorio.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping
	public ResponseEntity<Postagem> novaPostagem(@RequestBody Postagem addPost) {
		return ResponseEntity.status(201).body(repositorio.save(addPost));
	}
	
	@DeleteMapping("/deleta/{idPostagem}")
	public void deletePostagem (@PathVariable(value = "idPostagem") Long iddaPostagem) {
		repositorio.deleteById(iddaPostagem);
	}
	
	@PutMapping
	public ResponseEntity<Postagem> atualizaPostagem(@Valid @RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(repositorio.save(postagem));
	}

}
