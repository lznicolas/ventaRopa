package com.example.demo.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Persona implements Serializable {
    private Integer id;
    private LocalDateTime fechaAlta;
    private LocalDateTime fechaModificacion;
    private String cuil;
    private String apellido;
    private String nombre;
    private Direccion direccion;

    public Persona() {
    }

    public Persona(Integer id, String cuil, String apellido, String nombre, Direccion direccion) {
        this.id = id;
        this.cuil = cuil;
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
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

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", fechaAlta=" + fechaAlta +
                ", fechaModificacion=" + fechaModificacion +
                ", cuil='" + cuil + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion=" + direccion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(id, persona.id) && Objects.equals(cuil, persona.cuil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cuil);
    }
}
