package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Color {
    @Id
    @Column(name = "color_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    @ManyToOne(optional = true)
    @JoinColumn(name = "articulo_id", foreignKey = @ForeignKey(name = "FK_ARTICULO_ID"))
    private Articulo articulo;

}
