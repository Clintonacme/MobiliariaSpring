package com.muebleria.demo.model;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tb_usuarios")
@Data
public class Usuario {

	@Id
	 private int codigo;
	 public String nombre;
	 public String apellido;
	 public String usuario;
	 public String clave;
	 public LocalDate fnacim;
	 public int tipo;
	
	 
	 
}
