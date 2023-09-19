package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Articulo {
    @Id
    @Column(name = "articulo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String descripcion;
    private Double costo;
    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;
    private Double margenDeGanancia;
    private Double netoGrabado;
    private Double impuestoValorAgregado;
    private Double precioDeVenta;
    @ManyToOne
    @JoinColumn(name = "articulo_id")
    private Talle talle;

/*
    public Articulo( String descripcion, Double costo, Double margenDeGanancia, Double netoGrabado, Double impuestoValorAgregado, Double precioDeVenta) {
        //this.id = id;
        this.descripcion = descripcion;
        this.costo = costo;
        this.margenDeGanancia = margenDeGanancia;
        this.netoGrabado = netoGrabado;
        this.impuestoValorAgregado = impuestoValorAgregado;
        this.precioDeVenta = precioDeVenta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Double getMargenDeGanancia() {
        return margenDeGanancia;
    }

    public void setMargenDeGanancia(Double margenDeGanancia) {
        this.margenDeGanancia = margenDeGanancia;
    }

    public Double getNetoGrabado() {
        return netoGrabado;
    }

    public void setNetoGrabado(Double netoGrabado) {
        this.netoGrabado = netoGrabado;
    }

    public Double getImpuestoValorAgregado() {
        return impuestoValorAgregado;
    }

    public void setImpuestoValorAgregado(Double impuestoValorAgregado) {
        this.impuestoValorAgregado = impuestoValorAgregado;
    }

    public Double getPrecioDeVenta() {
        return precioDeVenta;
    }

    public void setPrecioDeVenta(Double precioDeVenta) {
        this.precioDeVenta = precioDeVenta;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", costo=" + costo +
                ", margenDeGanancia=" + margenDeGanancia +
                ", netoGrabado=" + netoGrabado +
                ", impuestoValorAgregado=" + impuestoValorAgregado +
                ", precioDeVenta=" + precioDeVenta +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Articulo articulo = (Articulo) o;
        return Objects.equals(id, articulo.id) && Objects.equals(descripcion, articulo.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion);
    }

 */
}
