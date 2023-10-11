package com.example.demo.services.contracts;

import com.example.demo.models.Articulo;

public interface ArticuloDAO extends GenericDAO<Articulo>{
    Articulo actualiza(Articulo entidad);

    //----------Modificar Articulo ---------------------------
    void actualizaArticulo(Long id, Articulo articulo);
}
