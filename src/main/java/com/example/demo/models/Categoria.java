package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @Column(name = "categoria_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;
    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;
    @Column(name = "numero_categoria")
    private Long nroCategoria;
    @Column(name = "categoria")
    private String categoria;
    @JoinColumn(name = "articulo_id")
    @OneToMany(
            mappedBy = "categoria",
            fetch = FetchType.LAZY
    )
    @JsonIgnoreProperties({"categoria"})
    private Set<Articulo> articulos;

    public Categoria() {
    }

    public Categoria(Long id, Long nroCategoria, String categoria) {
        this.id = id;
        this.nroCategoria = nroCategoria;
        this.categoria = categoria;
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

    public Long getNroCategoria() {
        return nroCategoria;
    }

    public void setNroCategoria(Long nroCategoria) {
        this.nroCategoria = nroCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Set<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(Set<Articulo> articulos) {
        this.articulos = articulos;
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
        return "Categoria{" +
                "id=" + id +
                ", fechaAlta=" + fechaAlta +
                ", fechaModificacion=" + fechaModificacion +
                ", nroCategoria=" + nroCategoria +
                ", categoria='" + categoria + '\'' +
                ", articulo=" + articulos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id) && Objects.equals(nroCategoria, categoria.nroCategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nroCategoria);
    }
}
