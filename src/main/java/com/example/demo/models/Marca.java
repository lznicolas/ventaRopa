package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Marca {
    @Id
    @Column(name = "marca_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    @OneToMany(
            mappedBy = "marca",
            fetch = FetchType.LAZY
    )
    private Set<Articulo> articuloSet;
}
