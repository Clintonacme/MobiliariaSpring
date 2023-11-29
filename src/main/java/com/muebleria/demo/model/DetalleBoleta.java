package com.muebleria.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.Data;
 
 @Data
 @Table(name="tb_det_boleta")
 @Entity
public class DetalleBoleta {
    @Column(name = "num_bol")
    private String numBol;
	@Min(value = 1001)
	@Id
	private int cod_prod;
	private String nomProd;
	@Min(value = 1)
	private int cantidad;
	private double preciovta;
	private double importe;


}
