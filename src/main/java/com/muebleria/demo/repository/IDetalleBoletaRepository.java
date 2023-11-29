package com.muebleria.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.muebleria.demo.model.Boleta;
import com.muebleria.demo.model.DetalleBoleta;

@Repository
public interface IDetalleBoletaRepository extends JpaRepository<DetalleBoleta,Integer> {
    @Query(value = "SELECT MAX(SUBSTRING(num_bol, 2)) FROM tb_boleta", nativeQuery = true)
    Optional<String> findMaxNumBoleta();

    default String generaNumBoleta() {
        String codigo = "B0001";  

        Optional<String> maxNumBoleta = findMaxNumBoleta();
        if (maxNumBoleta.isPresent()) {
            int maxNumBol = Integer.parseInt(maxNumBoleta.get());
            codigo = String.format("B%04d", maxNumBol + 1);
        }

        return codigo;
    }

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM tb_det_boleta  WHERE num_bol = :numBol", nativeQuery = true)
    int eliminarDetallesPorNumeroBoleta(@Param("numBol") String numBol);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO tb_boleta VALUES (?1, CURDATE(), ?2)", nativeQuery = true)
    int insertarCabeceraBoleta(String numBoleta, int codigo);

    /*@Transactional
    @Modifying
    @Query(value = "INSERT INTO tb_det_boleta (num_bol, cod_prod, cantidad, preciovta , importe , nom_prod) VALUES (?1, ?2, ?3, ?4, ?5 , ?6)", nativeQuery = true)
    int insertarDetalleBoleta(String numBoleta, int codProd, int cantidad, double precioVta , double importe , String nom_prod);*/

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO tb_det_boleta (num_bol, cod_prod, cantidad, preciovta, importe, nom_prod) " +
        "VALUES (?1, ?2, ?3, ?4, ?5, (SELECT descripcion FROM tb_productos WHERE cod_prod = ?2))",
        nativeQuery = true)
    int insertarDetalleBoleta(String numBoleta, int codProd, int cantidad, double precioVta, double importe);


    @Transactional
    @Modifying
    @Query(value = "UPDATE tb_productos SET stock = stock - ?1 WHERE cod_prod = ?2", nativeQuery = true)
    int actualizarStock(int cantidad, String idProd);

    default int realizarVenta(Boleta cab, List<DetalleBoleta> detalles) {
        int rs = 0;
        try {
            String numBoleta = generaNumBoleta();
           
          
            rs += insertarCabeceraBoleta(numBoleta, cab.getCodigo());

  
            Long count = countByNumBol(numBoleta);
            if (count > 0) {
                throw new RuntimeException("Ya existe una boleta con el número proporcionado");
            }

            for (DetalleBoleta d : detalles) {
                double precio = consultaPrecioProducto(d.getCod_prod());
                rs += insertarDetalleBoleta(numBoleta, d.getCod_prod(), d.getCantidad(), precio, d.getCantidad() * precio);
                rs += actualizarStock(d.getCantidad(), Integer.toString(d.getCod_prod()));
            }
        } catch (Exception e) {
            System.out.println("Error en realizarVenta: " + e.getMessage());
            rs = 0;
        }
        return rs;
    }

    @Query(value = "SELECT precio FROM tb_productos WHERE cod_prod = ?1", nativeQuery = true)
    Double consultaPrecioProducto(int codProd);

   @Query(value = "SELECT COUNT(*) FROM DetalleBoleta d WHERE d.numBol = :numBol")
    Long countByNumBol(@Param("numBol") String numBol);

    List<DetalleBoleta> findByNumBol(String numBol);


     @Procedure(name = "consultaFecha")
    List<Object[]> consultaFecha(@Param("fch_bol") String fchBol);

}
