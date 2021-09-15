package com.personalblog.blogisa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personalblog.blogisa.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findByNomeUsuarioContainingIgnoreCase (String nomeUsuario);
}
