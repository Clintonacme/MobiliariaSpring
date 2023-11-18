package com.muebleria.demo.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VentaRequest {
    private Boleta cabecera;
    private List<DetalleBoleta> detalles;
}
