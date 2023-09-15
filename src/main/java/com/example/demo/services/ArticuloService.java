package com.example.demo.services;

import com.example.demo.models.Articulo;
import com.example.demo.repositories.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloService {
    @Autowired
    private ArticuloRepository articuloRepository;

    private Double netoGrabado;
    private Double impuestoValorAgregado;
    private Double precioVenta;


    //Crear el Articulo

    public void crearArticulo(String descripcion, Double costo, Double margenDeGanancia){
        netoGrabado = costo + (costo*margenDeGanancia);
        impuestoValorAgregado = netoGrabado*0.21;
        precioVenta = impuestoValorAgregado + netoGrabado;
        Articulo articulo = new Articulo(descripcion,costo,margenDeGanancia,netoGrabado,impuestoValorAgregado,precioVenta);
        articuloRepository.save(articulo);
    }

    //Buscar un Articulo con su id
    public Articulo obtenerArticulo(Long  id){
        return articuloRepository.findById(id).orElse(null);
    }

    public List<Articulo> listarArticulos(){
        return articuloRepository.findAll();
    }

}
