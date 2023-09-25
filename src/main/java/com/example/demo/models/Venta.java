package com.example.demo.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venta {
    private Integer id;
    private Integer numeroDeVenta;
    private Date fecha;
    private Long numeroDeComprobante;
    private Float total;


}
