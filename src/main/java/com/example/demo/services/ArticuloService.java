package com.example.demo.services;

import com.example.demo.models.Articulo;
import com.example.demo.repositories.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ArticuloService {
    @Autowired
    private ArticuloRepository articuloRepository;

    @Value("${constants.alicuotaEspecial}")
    Double alicuota;

    private Double netoGrabado;
    private Double impuestoValorAgregado;
    private Double precioVenta;

    public Double calculaNetograbado(Articulo articulo){
        netoGrabado = articulo.getCosto() + (articulo.getCosto() * articulo.getMargenDeGanancia());
        return netoGrabado;
    }
    public Double calculaImpuestoValorAgregado(Articulo articulo){
        impuestoValorAgregado = articulo.getNetoGrabado() * alicuota;
        return impuestoValorAgregado;
    }

    public Double calculaPrecioVenta(Articulo articulo){
        precioVenta = articulo.getNetoGrabado() + articulo.getImpuestoValorAgregado();
        return precioVenta;
    }

    //-----------------Listar Articulos ------------------------
    public Articulo obtenerArticulo(Long  id){
        return articuloRepository.findById(id).orElse(null);
    }

    //----------------Buscar un Articulo con su id -------------
    public List<Articulo> listarArticulos(){
        return articuloRepository.findAll();
    }

    //----------------Crear Articulo ---------------------------
    public void crearArticulo(Articulo articulo){
        articulo.setNetoGrabado(calculaNetograbado(articulo));
        articulo.setImpuestoValorAgregado(calculaImpuestoValorAgregado(articulo));
        articulo.setPrecioDeVenta(calculaPrecioVenta(articulo));
        articuloRepository.save(articulo);
    }

    //------------Borrar Articulo ----------------------------
    public void borrarArticulo(Long id){
        articuloRepository.deleteAllById(Collections.singleton(id));
    }

    //----------Modificar Articulo ---------------------------
    public void actualizaArticulo(Long id, Articulo articulo){
        Articulo articuloActualizado = articuloRepository.findById(id).get();
        articuloActualizado.setDescripcion(articulo.getDescripcion());
        articuloActualizado.setCosto(articulo.getCosto());
        articuloActualizado.setMargenDeGanancia(articulo.getMargenDeGanancia());
        articuloActualizado.setMarca(articulo.getMarca());
        articuloActualizado.setNetoGrabado(calculaNetograbado(articuloActualizado));
        articuloActualizado.setImpuestoValorAgregado(calculaImpuestoValorAgregado(articuloActualizado));
        articuloActualizado.setPrecioDeVenta(calculaPrecioVenta(articuloActualizado));
        articuloRepository.save(articuloActualizado);
    }
}
