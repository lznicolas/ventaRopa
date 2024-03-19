package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class PuntoVenta {
    @Id
    @Column(name = "punto_de_venta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaAlta;
    private LocalDateTime fechaModificacion;

    private Integer nroPtoVta;
    private Sucursal sucursal;

    public PuntoVenta() {
    }

    public PuntoVenta(Long id, Integer nroPtoVta, Sucursal sucursal) {
        this.id = id;
        this.nroPtoVta = nroPtoVta;
        this.sucursal = sucursal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getNroPtoVta() {
        return nroPtoVta;
    }

    public void setNroPtoVta(Integer nroPtoVta) {
        this.nroPtoVta = nroPtoVta;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return "PuntoVenta{" +
                "id=" + id +
                ", fechaAlta=" + fechaAlta +
                ", fechaModificacion=" + fechaModificacion +
                ", nroPtoVta=" + nroPtoVta +
                ", sucursal=" + sucursal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PuntoVenta that = (PuntoVenta) o;
        return Objects.equals(nroPtoVta, that.nroPtoVta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nroPtoVta);
    }
}
