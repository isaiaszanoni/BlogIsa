package com.isaBlog.isaBlog.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/teste")
	public String testando() {
		return "Isso é um teste - Usuario";
	}
}
