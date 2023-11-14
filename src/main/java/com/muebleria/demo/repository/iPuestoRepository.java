package com.muebleria.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muebleria.demo.model.Puesto;



public interface iPuestoRepository extends JpaRepository<Puesto, Integer> {
	//Metodos Crud
}
