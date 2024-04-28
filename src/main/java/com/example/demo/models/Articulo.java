package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "articulos")
public class Articulo {
    @Id
    @Column(name = "articulo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;
    @Column(name="fecha_modificacion")
    private LocalDateTime fechaModificacion;
    @Column(name="codigo_articulo")
    private Long codigoArticulo;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="costo")
    private Double costo;
    @Column(name="marca")
    @OneToMany(
            mappedBy = "articulos",
            fetch = FetchType.LAZY
    )
    private Marca marca;
    @Column(name = "margen_ganancia")
    private Double margenDeGanancia;

    @Column(name = "neto_grabado")
    private Double netoGrabado;
    @Column(name = "impuesto_valor_agregado")
    private Double impuestoValorAgregado;
    @Column(name = "precio_venta")
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


    @ManyToOne(
            optional = true,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(
            name = "categoria_id",
            foreignKey = @ForeignKey(name = "FK_CATEGORIA_ID")
    )
    private Categoria categoria;


    @ManyToOne(
            optional = true,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(
            name = "color_id",
            foreignKey = @ForeignKey(name = "FK_COLOR_ID")
    )
    private Color color;
    @Column(name = "stock")
    private Stock stock;

    public Articulo() {
    }

    public Articulo(Long id, Long codigoArticulo, String descripcion, Double costo, TipoTalle tipoTalle, Set<Talle> talle, Categoria categoria, Color color) {
        this.id = id;
        this.codigoArticulo = codigoArticulo;
        this.descripcion = descripcion;
        this.costo = costo;
        this.tipoTalle = tipoTalle;
        this.talle = talle;
        this.categoria = categoria;
        this.color = color;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @PrePersist
    private void antesDePersistir(){
        this.fechaAlta = LocalDateTime.now();
    }
    @PreUpdate
    private void antesDeUpdate(){
        this.fechaModificacion = LocalDateTime.now();
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
                ", color=" + color +
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
        return Objects.hash(id);
    }
}
