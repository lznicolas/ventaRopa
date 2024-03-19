package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
public class Sucursal {
    @Id
    @Column(name = "sucursal_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaAlta;
    private LocalDateTime fechaModificacion;
    private Integer nroDeSucursal;
    private Set<Stock> stocks;

    public Sucursal() {
    }

    public Sucursal(Long id, Integer nroDeSucursal) {
        this.id = id;
        this.nroDeSucursal = nroDeSucursal;
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

    public Integer getNroDeSucursal() {
        return nroDeSucursal;
    }

    public void setNroDeSucursal(Integer nroDeSucursal) {
        this.nroDeSucursal = nroDeSucursal;
    }

    public Set<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }

    @Override
    public String toString() {
        return "Sucursal{" +
                "id=" + id +
                ", fechaAlta=" + fechaAlta +
                ", fechaModificacion=" + fechaModificacion +
                ", nroDeSucursal=" + nroDeSucursal +
                ", stocks=" + stocks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sucursal sucursal = (Sucursal) o;
        return Objects.equals(nroDeSucursal, sucursal.nroDeSucursal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nroDeSucursal);
    }

}
