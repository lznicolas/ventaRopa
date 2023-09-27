package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    @Id
    @Column(name = "stock_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cantidad;
    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;
    @ManyToOne
    @JoinColumn(name = "articulo_id")
    private Articulo articulo;
    @ManyToOne
    @JoinColumn(name = "talle_id")
    private Talle talle;

}
