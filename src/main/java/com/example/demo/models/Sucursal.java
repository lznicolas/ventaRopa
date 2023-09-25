package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sucursal {
    @Id
    @Column(name = "sucursal_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer nroDeSucursal;

}
