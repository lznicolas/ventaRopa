package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Talle {
    @Id
    @Column(name = "talle_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "articulo_id", foreignKey = @ForeignKey(name = "FK_TIPOTALLE_ID"))
    private TipoTalle tipoTalle;

}
