package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venta {
    @Id
    @Column(name = "venta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer numeroDeVenta;
    private LocalDateTime fecha;
    private Long numeroDeComprobante;
    private Float total;
    @OneToMany(
            mappedBy = "Venta",
            fetch = FetchType.LAZY
    )
    private Set<LineaDeVenta> lineaDeVenta;


}
