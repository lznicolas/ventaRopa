package com.example.demo.controllers;


import com.example.demo.models.Articulo;
import com.example.demo.models.Marca;
import com.example.demo.services.implementations.MarcaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/marca")
public class MarcaController {
    //----------Declaracion de variables INI------------
    @Autowired
    private MarcaService marcaService;
    @Autowired
    ObjectMapper mapper;
    //---------Declacarion de variables FIN ------------

    //---------Listado de Marca ------------------------
    @GetMapping("/lista")
    public Iterable<Marca> findAll(){
        return marcaService.findAll();
    }

    //--------Muestra una Marca ------------------------
    @GetMapping("/lista/{id}")
    public Optional<Marca> obtenerMarca(@PathVariable Long id){
        return marcaService.findById(id);
    }

    //--------Crear Marca -------------------------------
    @PostMapping("/nuevamarca")
    @ResponseBody
    public Marca crearMarca(Marca marca){
        return marcaService.save(marca);
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarMarca(@PathVariable Long id){
        marcaService.deleteById(id);
    }

    @PutMapping("/actualiza/{id}")
    public void actualizaMarca(@PathVariable Long id, @RequestBody Marca marca){
        marcaService.actualiza(id, marca);
    }

}
