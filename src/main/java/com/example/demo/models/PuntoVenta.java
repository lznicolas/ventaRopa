package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PuntoVenta {
    @Id
    @Column(name = "punto_de_venta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer nroPtoVta;

}
