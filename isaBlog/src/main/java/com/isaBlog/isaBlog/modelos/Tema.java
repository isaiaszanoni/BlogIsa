package com.isaBlog.isaBlog.modelos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Tema {
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idTema;
	private String nomeTema;
	
	@OneToMany(mappedBy = "tema", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("tema")
	private List<Postagem> postagem;

	public List<Postagem> getPostagens() {
		return postagem;
	}

	public Long getIdTema() {
		return idTema;
	}


	public void setIdTema(Long idTema) {
		this.idTema = idTema;
	}
	


	public List<Postagem> getPostagem() {
		return postagem;
	}


	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}


	public String getNomeTema() {
		return nomeTema;
	}

	public void setNomeTema(String tema) {
		this.nomeTema = tema;
	}

	public void setPostagens(List<Postagem> postagem) {
		this.postagem = postagem;
	}
	
}


