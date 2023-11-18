package com.muebleria.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muebleria.demo.model.Boleta;

@Repository
public interface IBoletaRepository extends JpaRepository<Boleta, String> {
    
}
