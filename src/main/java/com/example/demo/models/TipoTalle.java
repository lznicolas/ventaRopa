package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
public class TipoTalle {
    @Id
    @Column(name = "tipo_talle_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaAlta;
    private LocalDateTime fechaModificacion;
    private String descripcionTipoT;
    @OneToMany(
            mappedBy = "TipoTalle",
            fetch = FetchType.LAZY
    )
    private Set<Talle> talle;

    public TipoTalle(){}

    public TipoTalle(Long id, String descripcionTipoT) {
        this.id = id;
        this.descripcionTipoT = descripcionTipoT;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcionTipoT() {
        return descripcionTipoT;
    }

    public void setDescripcionTipoT(String descripcionTipoT) {
        this.descripcionTipoT = descripcionTipoT;
    }

    public Set<Talle> getTalle() {
        return talle;
    }

    public void setTalle(Set<Talle> talle) {
        this.talle = talle;
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

    @Override
    public String toString() {
        return "TipoTalle{" +
                "id=" + id +
                ", fechaAlta=" + fechaAlta +
                ", fechaModificacion=" + fechaModificacion +
                ", descripcionTipoT='" + descripcionTipoT + '\'' +
                ", talle=" + talle +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoTalle tipoTalle = (TipoTalle) o;
        return Objects.equals(id, tipoTalle.id) && Objects.equals(descripcionTipoT, tipoTalle.descripcionTipoT);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcionTipoT);
    }
}
