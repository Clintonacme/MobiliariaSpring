package com.muebleria.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
 
 @Data
 @Table(name="tb_det_boleta")
 @Entity
public class DetalleBoleta {
    @Column(name = "num_bol")
    private String numBol;
	@Min(value = 1001)
	@Max(value = 1006)
	@Id
	private int cod_prod;
	@NotBlank
	private String nomProd;
	@Min(value = 1)
	private int cantidad;
	@DecimalMin(value =  "1.0")
	private double preciovta;
	@DecimalMin(value =  "1.0")
	private double importe;


}
