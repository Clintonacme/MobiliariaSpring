package com.muebleria.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.muebleria.demo.model.Boleta;

@Repository
public interface IBoletaRepository extends JpaRepository<Boleta, String> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM tb_boleta  WHERE num_bol = :numBol", nativeQuery = true)
    int eliminarBoletaPorNumeroBoleta(@Param("numBol") String numBol);
}
