package com.muebleria.demo.model;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Setter;


@Setter
public class ProveedorRequest {
    @Min(value= 1001)
    public int cod_provee;

    @Size(max = 25)
    @NotBlank
    public String razon;
    
    @Pattern(regexp = "\\d{11}", message = "El ruc debe tener únicamente 11 caracteres")
     @NotBlank
	public String ruc;
    
}
