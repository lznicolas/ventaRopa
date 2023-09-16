package com.example.demo.services;

import com.example.demo.models.Articulo;
import com.example.demo.models.Marca;
import com.example.demo.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MarcaService {
    //----------Declaracion de variables INI------------
    @Autowired
    private MarcaRepository marcaRepository;


    //----------Declaracion de variables FIN------------

    //----------Busca una marca------------
    public Marca obtenerMarca(Long  id){
        return marcaRepository.findById(id).orElse(null);
    }


    //----------Busca una lista de marcas------------
    public List<Marca> listarMarcas(){
        return marcaRepository.findAll();
    }

    //----------Crea Marca------------
    public void crearMarca(Marca marca){
        marcaRepository.save(marca);
    }
    //----------Actualiza marca------------
    public void actualizaMarca(Long id, Marca marca){
        Marca marcaActualizada = marcaRepository.findById(id).get();
        marcaActualizada.setMarca(marca.getMarca());
        marcaRepository.save(marcaActualizada);
    }

    //----------Borra Marca------------
    public void borrarMarca(Long id){
        marcaRepository.deleteAllById(Collections.singleton(id));
    }
}
