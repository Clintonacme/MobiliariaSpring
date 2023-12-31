package com.muebleria.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muebleria.demo.model.Clientes;

@Repository
public interface iClienteRepository extends JpaRepository<Clientes, Integer> {
	//Metodos Crud
	List<Clientes> findByNombreContaining(String nombre);

}
