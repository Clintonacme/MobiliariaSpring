package com.muebleria.demo.model;


import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Setter;

@Setter
public class UsuarioRequest {


    @NotBlank(message = "complete el campo nombre")
    @Pattern(regexp = "[a-zA-Z\\s]+")
    public String nombre;

    @Pattern(regexp = "[a-zA-Z\\s]+")
    @NotBlank(message = "complete el campo apellido")
    public String apellido;

    @NotBlank(message = "complete el campo usuario")
    @Size(max = 25, message = "El usuario debe tener como máximo 15 caracteres")
    public String usuario;

    @NotBlank(message = "complete el campo clave")
    @Pattern(regexp = "^.{5}$", message = "La clave debe tener únicamente 5 caracteres")
    public String clave;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    public String fnacim;

    @Min(value = 1)
    @Max(value = 2)
    public int tipo;
}
