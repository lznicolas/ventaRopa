package com.example.demo.models;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

public class CondicionTributaria {
    private Long id;
    private LocalDateTime fechaAlta;
    private LocalDateTime fechaModificacion;
    private String descripcion;
    private Set<Cliente> clientes;
    private Set<TipoComprobante> tipoComprobantes;

    public CondicionTributaria() {
    }

    public CondicionTributaria(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Set<TipoComprobante> getTipoComprobantes() {
        return tipoComprobantes;
    }

    public void setTipoComprobantes(Set<TipoComprobante> tipoComprobantes) {
        this.tipoComprobantes = tipoComprobantes;
    }

    @Override
    public String toString() {
        return "CondicionTributaria{" +
                "id=" + id +
                ", fechaAlta=" + fechaAlta +
                ", fechaModificacion=" + fechaModificacion +
                ", descripcion='" + descripcion + '\'' +
                ", clientes=" + clientes +
                ", tipoComprobantes=" + tipoComprobantes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CondicionTributaria that = (CondicionTributaria) o;
        return Objects.equals(id, that.id) && Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion);
    }
}
