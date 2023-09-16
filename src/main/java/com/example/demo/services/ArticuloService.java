package com.example.demo.services;

import com.example.demo.models.Articulo;
import com.example.demo.repositories.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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



    //Crear el Articulo

    public void crearArticulo(Articulo articulo){

        netoGrabado = articulo.getCosto() + (articulo.getCosto()*articulo.getMargenDeGanancia());
        impuestoValorAgregado = netoGrabado*alicuota;
        precioVenta = impuestoValorAgregado + netoGrabado;
        articulo.setNetoGrabado(netoGrabado);
        articulo.setImpuestoValorAgregado(impuestoValorAgregado);
        articulo.setPrecioDeVenta(precioVenta);
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
