package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tiendas")
public class Tienda {
    @Id
    @Column(name = "tienda_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;
    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "numero_telefono")
    private String nroDeTelefono;
    @Column(name = "direccion")
    private Direccion direccion;
    @Column(name = "cuit")
    private Long CUIT;

    private Set<Sucursal> sucursals;

    public Tienda() {
    }

    public Tienda(Long id, String nombre, String nroDeTelefono, Direccion direccion, Long CUIT) {
        this.id = id;
        this.nombre = nombre;
        this.nroDeTelefono = nroDeTelefono;
        this.direccion = direccion;
        this.CUIT = CUIT;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNroDeTelefono() {
        return nroDeTelefono;
    }

    public void setNroDeTelefono(String nroDeTelefono) {
        this.nroDeTelefono = nroDeTelefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Long getCUIT() {
        return CUIT;
    }

    public void setCUIT(Long CUIT) {
        this.CUIT = CUIT;
    }

    public Set<Sucursal> getSucursals() {
        return sucursals;
    }

    public void setSucursals(Set<Sucursal> sucursals) {
        this.sucursals = sucursals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tienda tienda = (Tienda) o;
        return Objects.equals(id, tienda.id) && Objects.equals(nombre, tienda.nombre) && Objects.equals(nroDeTelefono, tienda.nroDeTelefono) && Objects.equals(direccion, tienda.direccion) && Objects.equals(CUIT, tienda.CUIT);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, nroDeTelefono, direccion, CUIT);
    }
}
