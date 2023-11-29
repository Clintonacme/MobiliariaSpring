package com.muebleria.demo.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Setter;

@Setter
public class ProductoRequest {
    public int cod_prod;
	@Min(value= 1001)
    public int cod_provee;

	@Pattern(regexp = "[0-9a-zA-Z\\s]+")
    @NotBlank
	public String descripcion;

	@Min(value = 1)
	public int idtipo;
	@Min(value = 1)
	public int stock;
	
	@DecimalMin(value = "1.0")
	public double precio;
}
