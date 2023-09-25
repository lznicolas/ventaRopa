package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venta {
    @Id
    @Column(name = "venta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer numeroDeVenta;
    private Date fecha;
    private Long numeroDeComprobante;
    private Float total;
    private LineaDeVenta lineaDeVenta;


}
