package com.muebleria.demo.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Setter;

@Setter
public class EmpleadosRequest {
    public int codigo;
    @NotBlank(message = "complete el campo nombre")
    @Pattern(regexp = "[a-zA-Z\\s]+")
	public String nombre;
    @Pattern(regexp = "[a-zA-Z\\s]+")
    @NotBlank(message = "complete el campo apellido")
	public String apellido;
    @Min(value = 1)
	public int puesto;
}
