package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
public class TipoTalle {
    @Id
    @Column(name = "tipo_talle_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcionTipoT;
    @OneToMany(
            mappedBy = "TipoTalle",
            fetch = FetchType.LAZY
    )
    private Set<Talle> talle;

    public TipoTalle(){}

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

}
