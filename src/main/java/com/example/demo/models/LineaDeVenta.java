package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity

public class LineaDeVenta {
    @Id
    @Column(name = "linea_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaAlta;
    private LocalDateTime fechaModificacion;
    private Integer cantidad;
    private Float subtotal;
    private Stock stock;

    public LineaDeVenta() {
    }


}
