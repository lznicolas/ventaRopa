package com.example.demo.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tienda {
    private Long id;
    private String nombre;
    private String nroDeTelefono;
    private String direccion;
    private Long CUIT;

}
