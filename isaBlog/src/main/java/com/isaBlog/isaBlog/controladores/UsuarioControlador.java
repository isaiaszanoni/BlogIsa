package com.isaBlog.isaBlog.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isaBlog.isaBlog.modelos.Usuario;
import com.isaBlog.isaBlog.repositorios.UsuarioRepositorio;

@RestController
@RequestMapping("/api/v0-1/usuario")
public class UsuarioControlador {
	
	private @Autowired UsuarioRepositorio repositorio;
	
	@GetMapping("/todes")
	public List<Usuario> PegaTodes(){
		return repositorio.findAll();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Usuario> GetById(@PathVariable Long id){
		return repositorio.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	// post, delete, put
	@PostMapping
	public ResponseEntity<Usuario> addUsuario(@Valid @RequestBody Usuario novoUsuario){
		return ResponseEntity.status(201).body(repositorio.save(novoUsuario));
	}
	
	@DeleteMapping("/deleta/{idUsuario}")
	public void deleteUsuario(@PathVariable (value = "idUsuario") Long idUsuario) {
		repositorio.deleteById(idUsuario);
	}
	
	@PutMapping
	public ResponseEntity<Usuario> atualizaUsuario(@Valid @RequestBody Usuario atualizaUsuario){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(repositorio.save(atualizaUsuario));
	}
}
