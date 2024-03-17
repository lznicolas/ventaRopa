package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
public class Articulo {
    @Id
    @Column(name = "articulo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaAlta;
    private LocalDateTime fechaModificacion;
    private Long codigoArticulo;
    private String descripcion;
    private Double costo;
    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;


    private Double margenDeGanancia;


    private Double netoGrabado;


    private Double impuestoValorAgregado;


    private Double precioDeVenta;

    /*@OneToMany(
            mappedBy = "articulo",
            fetch = FetchType.LAZY
    )*/
    private TipoTalle tipoTalle;


    @OneToMany(
            mappedBy = "articulo",
            fetch = FetchType.LAZY
    )
    private Set<Talle> talle;


    @OneToMany(
            mappedBy = "articulo",
            fetch = FetchType.LAZY
    )
    private Set<Categoria> categoria;


    @OneToMany(
            mappedBy = "articulo",
            fetch = FetchType.LAZY
    )
    private Set<Color> colors;

    public Articulo() {
    }

    public Articulo(Long id, Long codigoArticulo, String descripcion, Double costo, TipoTalle tipoTalle, Set<Talle> talle, Set<Categoria> categoria, Set<Color> colors) {
        this.id = id;
        this.codigoArticulo = codigoArticulo;
        this.descripcion = descripcion;
        this.costo = costo;
        this.tipoTalle = tipoTalle;
        this.talle = talle;
        this.categoria = categoria;
        this.colors = colors;
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

    public Long getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(Long codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
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

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
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

    public TipoTalle getTipoTalle() {
        return tipoTalle;
    }

    public void setTipoTalle(TipoTalle tipoTalle) {
        this.tipoTalle = tipoTalle;
    }

    public Set<Talle> getTalle() {
        return talle;
    }

    public void setTalle(Set<Talle> talle) {
        this.talle = talle;
    }

    public Set<Categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(Set<Categoria> categoria) {
        this.categoria = categoria;
    }

    public Set<Color> getColors() {
        return colors;
    }

    public void setColors(Set<Color> colors) {
        this.colors = colors;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "id=" + id +
                ", fechaAlta=" + fechaAlta +
                ", fechaModificacion=" + fechaModificacion +
                ", codigoArticulo=" + codigoArticulo +
                ", descripcion='" + descripcion + '\'' +
                ", costo=" + costo +
                ", marca=" + marca +
                ", margenDeGanancia=" + margenDeGanancia +
                ", netoGrabado=" + netoGrabado +
                ", impuestoValorAgregado=" + impuestoValorAgregado +
                ", precioDeVenta=" + precioDeVenta +
                ", tipoTalle=" + tipoTalle +
                ", talle=" + talle +
                ", categoria=" + categoria +
                ", colors=" + colors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Articulo articulo = (Articulo) o;
        return Objects.equals(id, articulo.id) && Objects.equals(codigoArticulo, articulo.codigoArticulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigoArticulo);
    }
}
