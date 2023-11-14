package com.muebleria.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muebleria.demo.model.TipoUsuario;

public interface ITipoUsuarioRepository 
			extends JpaRepository<TipoUsuario, Integer>{

}
