package com.personalblog.blogisa.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.personalblog.blogisa.model.Usuario;
import com.personalblog.blogisa.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repositorio;
	
	@GetMapping("/todes")
	public ResponseEntity<List<Usuario>> pegaTodes() {
		List<Usuario> usuarioLista = repositorio.findAll();
		
		if (usuarioLista.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(usuarioLista);
		}
	}
	
	@GetMapping("/nomeUsuario/{nomeUsuario}")
    public ResponseEntity<Optional<Usuario>> getByNomeUsuario (@PathVariable(value = "nomeUsuario") String nomeUsuario){
        Optional<Usuario> objetoUsuarios = repositorio.findByNomeUsuarioContainingIgnoreCase(nomeUsuario);
        if(objetoUsuarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        }else {
            return ResponseEntity.status(200).body(objetoUsuarios);
        }
    }
	
	@PutMapping("/atualizar")
	public ResponseEntity<Usuario> atualizar(@Valid @RequestBody Usuario nomeUsuario) {
		return ResponseEntity.status(201).body(repositorio.save(nomeUsuario));
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<Usuario> salvar(@Valid @RequestBody Usuario novoUsuario) {
		return ResponseEntity.status(201).body(repositorio.save(novoUsuario));
	}
	
	@DeleteMapping("/deletar/{id_usuario}")
	public void deletarPostagemPorId(@PathVariable(value = "idUsuario") Long idUsuario) {
		repositorio.deleteById(idUsuario);
	}

}
