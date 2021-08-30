package com.isaBlog.isaBlog.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isaBlog.isaBlog.modelos.Tema;
import com.isaBlog.isaBlog.repositorios.TemaRepositorio;

@RestController
@RequestMapping("/api/v0-1/tema")
public class TemaControlador {
	
	private @Autowired TemaRepositorio repositorio;
	
	@GetMapping("/todos")
	public ResponseEntity<List<Tema>> PegaTodes(){
		return ResponseEntity.ok(repositorio.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tema> GetById(@PathVariable Long id){
		return repositorio.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/teste")
	public String testando() {
		return "Isso é só um teste - Tema";
	}

}
