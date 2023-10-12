package com.example.demo.services.implementations;

import com.example.demo.models.Articulo;
import com.example.demo.repositories.ArticuloRepository;
import com.example.demo.services.contracts.ArticuloDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ArticuloService implements ArticuloDAO {
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


    //----------------Buscar un Articulo con su id -------------
    @Override
    @Transactional(readOnly = true)
    public Optional<Articulo> findById(Long id) {
        return Optional.empty();
    }
    //----------------Crear Articulo ---------------------------
    @Override
    @Transactional
    public Articulo save(Articulo articulo) {
        articulo.setNetoGrabado(calculaNetograbado(articulo));
        articulo.setImpuestoValorAgregado(calculaImpuestoValorAgregado(articulo));
        articulo.setPrecioDeVenta(calculaPrecioVenta(articulo));
        return articuloRepository.save(articulo);
    }


    //-----------------Listar Articulos ------------------------
    @Override
    @Transactional(readOnly = true)
    public Iterable<Articulo> findAll(){
        return articuloRepository.findAll();
    }
    //------------Borrar Articulo ----------------------------
    @Override
    @Transactional
    public void deleteById(Long id) {

    }
    //----------Modificar Articulo ---------------------------
    @Override
    public Articulo actualiza(Long id, Articulo articulo) {
        Articulo articuloActualizado = articuloRepository.findById(id).get();
        articuloActualizado.setDescripcion(articulo.getDescripcion());
        articuloActualizado.setCosto(articulo.getCosto());
        articuloActualizado.setMargenDeGanancia(articulo.getMargenDeGanancia());
        articuloActualizado.setMarca(articulo.getMarca());
        articuloActualizado.setNetoGrabado(calculaNetograbado(articuloActualizado));
        articuloActualizado.setImpuestoValorAgregado(calculaImpuestoValorAgregado(articuloActualizado));
        articuloActualizado.setPrecioDeVenta(calculaPrecioVenta(articuloActualizado));
        return articuloRepository.save(articuloActualizado);
    }

}
