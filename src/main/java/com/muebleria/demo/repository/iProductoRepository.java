package com.muebleria.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muebleria.demo.model.Productos;

@Repository
public interface iProductoRepository extends JpaRepository<Productos, Integer> {
	//Metodos Crud
	List<Productos> findByDescripcionContaining(String descripcion);
	
	List<Productos> searchByDescripcionContains(String descripcion);
}
