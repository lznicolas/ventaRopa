package com.example.demo.controllers;

import com.example.demo.models.Articulo;
import com.example.demo.services.implementations.ArticuloService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/articulo")
public class ArticuloController {
    @Autowired
    private ArticuloService articuloService;
    @Autowired
    Gson gson;
    @Autowired
    ObjectMapper mapper;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String healthCheck(){
        return "Funciona";
    }

    //Listado de Articulos

    @GetMapping("/lista")
    public Iterable<Articulo> listarArticulos(){
        return articuloService.findAll();
    }

    @GetMapping("/lista/{id}")
    public Optional<Articulo> obtenerArticulo(@PathVariable Long id){
        return articuloService.findById(id);
    }

    //Creacion de Articulos
    @PostMapping("/nuevoarticulo")
    @ResponseBody
    public Articulo save(Articulo articulo){
        return articuloService.save(articulo);
    }
    /*public HttpStatus creaArticulo(HttpEntity<String> request) throws JsonProcessingException {
        //articuloService.crearArticulo(gson.fromJson(request.getBody(),Articulo.class));
        articuloService.crearArticulo(mapper.readValue(request.getBody(),Articulo.class));
        return HttpStatus.OK;

        //articuloService.crearArticulo(descripcion,costo,margenDeGanancia);
    }*/

    @DeleteMapping("/borrar/{id}")
    public void borrarArticulo(@PathVariable Long id){
        articuloService.borrarArticulo(id);
    }

    @PutMapping("/actualiza/{id}")
    public void actualizaArticulo(@PathVariable Long id, @RequestBody Articulo articulo){
        articuloService.actualizaArticulo(id, articulo);
    }



}
