package com.muebleria.demo.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Setter;

@Setter
public class EmpleadosRequest {
    public int codigo;
    @NotBlank(message = "complete el campo nombre")
    @Pattern(regexp = "[a-zA-Z]+")
	public String nombre;
    @Pattern(regexp = "[a-zA-z]+")
    @NotBlank(message = "complete el campo apellido")
	public String apellido;
    @Max(value = 4)
	public int puesto;
}
