package com.muebleria.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
 
 @Data
 @Table(name="tb_det_boleta")
 @Entity
public class DetalleBoleta {
    @Column(name = "num_bol")
    private String numBol;
	@Id
	private int cod_prod;
	private String nomProd;
	private int cantidad;
	private double preciovta;
	private double importe;


}
