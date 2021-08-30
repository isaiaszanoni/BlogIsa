package com.isaBlog.isaBlog.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isaBlog.isaBlog.modelos.Tema;

@Repository
public interface TemaRepositorio extends JpaRepository<Tema, Long>{

}
