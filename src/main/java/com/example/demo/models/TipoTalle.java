package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoTalle {
    @Id
    @Column(name = "tipo_talle_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcionTipoT;
    @OneToMany(
            mappedBy = "TipoTalle",
            fetch = FetchType.LAZY
    )
    private Set<Talle> talle;

}
