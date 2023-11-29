package com.muebleria.demo.controller;

import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.muebleria.demo.model.Boleta;
import com.muebleria.demo.model.DetalleBoleta;
import com.muebleria.demo.model.VentaRequest;
import com.muebleria.demo.repository.IBoletaRepository;
import com.muebleria.demo.repository.IDetalleBoletaRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping("ventas")
@AllArgsConstructor
public class VentaController {
    private IDetalleBoletaRepository repoDetalle;
    private IBoletaRepository repoBoleta;

    @GetMapping
    public List<Boleta> obtenerBoletas(){
        return repoBoleta.findAll();
    }


    
    @GetMapping("{numBol}")
    public List<DetalleBoleta> findByDetalleBoleta(@PathVariable String numBol){
        return repoDetalle.findByNumBol(numBol);
    }

    @Transactional(readOnly = false)
    @GetMapping("consulta")
    public List<Object[]> consultarPorFecha(@RequestParam("fch_bol") @DateTimeFormat(pattern = "yyyy-MM-dd") String fecha) {
        return repoDetalle.consultaFecha(fecha);
    }


    @PostMapping("generar")
    public ResponseEntity<String> realizarVenta(@RequestBody @Valid VentaRequest ventaRequest) {
        Boleta cabecera = ventaRequest.getCabecera();
        List<DetalleBoleta> detalles = ventaRequest.getDetalles();

        int resultado = repoDetalle.realizarVenta(cabecera, detalles);

        if (resultado > 0) {
            return ResponseEntity.ok("Venta realizada con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la venta");
        }
    }

    @DeleteMapping("{numBol}")
    public ResponseEntity<String> eliminarDetalleBoletaPorNumBoleta(@PathVariable @Valid String numBol) {
        int resultado2 = repoDetalle.eliminarDetallesPorNumeroBoleta(numBol);
        int resultado1 = repoBoleta.eliminarBoletaPorNumeroBoleta(numBol);
        
        if (resultado2 > 0 && resultado1 > 0) {
            return ResponseEntity.ok("Boleta y detalles eliminados con éxito para el número de boleta: " + numBol);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la boleta para el número de boleta: " + numBol);
        }
}

   
}
