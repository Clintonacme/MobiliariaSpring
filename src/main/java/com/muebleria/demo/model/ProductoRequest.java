package com.muebleria.demo.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Setter;

@Setter
public class ProductoRequest {
    public int cod_prod;
	@Min(value= 1001)
	@Max(value = 1006)
    public int cod_provee;
    @NotBlank
	public String descripcion;
	@Min(value = 1)
	@Max(value = 2)
	public int idtipo;
	public int stock;
	@DecimalMin(value = "1.0")
	public double precio;
}
