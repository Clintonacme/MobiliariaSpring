package com.muebleria.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muebleria.demo.model.Boleta;
import com.muebleria.demo.model.DetalleBoleta;
import com.muebleria.demo.model.VentaRequest;
import com.muebleria.demo.repository.IBoletaRepository;
import com.muebleria.demo.repository.IDetalleBoletaRepository;

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
    public ResponseEntity<DetalleBoleta> findByDetalleBoleta(@PathVariable String numBol){
        return ResponseEntity.of(repoDetalle.findByNumBol(numBol));
    }


    @PostMapping("generar")
    public ResponseEntity<String> realizarVenta(@RequestBody VentaRequest ventaRequest) {
        Boleta cabecera = ventaRequest.getCabecera();
        List<DetalleBoleta> detalles = ventaRequest.getDetalles();

        int resultado = repoDetalle.realizarVenta(cabecera, detalles);

        if (resultado > 0) {
            return ResponseEntity.ok("Venta realizada con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la venta");
        }
    }
}
