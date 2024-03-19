package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class Venta {
    @Id
    @Column(name = "venta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime fechaAlta;
    private LocalDateTime fechaModificacion;
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

    public Venta() {
    }

    public Venta(Integer id, LocalDateTime fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getNumeroDeVenta() {
        return numeroDeVenta;
    }

    public void setNumeroDeVenta(Integer numeroDeVenta) {
        this.numeroDeVenta = numeroDeVenta;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Long getNumeroDeComprobante() {
        return numeroDeComprobante;
    }

    public void setNumeroDeComprobante(Long numeroDeComprobante) {
        this.numeroDeComprobante = numeroDeComprobante;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Set<LineaDeVenta> getLineaDeVenta() {
        return lineaDeVenta;
    }

    public void setLineaDeVenta(Set<LineaDeVenta> lineaDeVenta) {
        this.lineaDeVenta = lineaDeVenta;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id=" + id +
                ", fechaAlta=" + fechaAlta +
                ", fechaModificacion=" + fechaModificacion +
                ", numeroDeVenta=" + numeroDeVenta +
                ", fecha=" + fecha +
                ", numeroDeComprobante=" + numeroDeComprobante +
                ", total=" + total +
                ", lineaDeVenta=" + lineaDeVenta +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venta venta = (Venta) o;
        return Objects.equals(numeroDeVenta, venta.numeroDeVenta) && Objects.equals(numeroDeComprobante, venta.numeroDeComprobante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroDeVenta, numeroDeComprobante);
    }
}
