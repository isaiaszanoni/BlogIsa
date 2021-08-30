package com.isaBlog.isaBlog.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isaBlog.isaBlog.modelos.Postagem;

@Repository
public interface PostagemRepositorio extends JpaRepository<Postagem, Long> {

	Object findAllByTituloContainingIgnoreCase(String titulo);


}
