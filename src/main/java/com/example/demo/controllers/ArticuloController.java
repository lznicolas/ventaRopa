package com.example.demo.controllers;

import com.example.demo.models.Articulo;
import com.example.demo.repositories.ArticuloRepository;
import com.example.demo.services.ArticuloService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articulos")
public class ArticuloController {
    @Autowired
    private ArticuloService articuloService;
    @Autowired
    Gson gson;
    @Autowired
    ObjectMapper mapper;

    //Listado de Articulos
    @GetMapping("/{id}")
    public Articulo obtenerArticulo(@PathVariable Long id){
        return articuloService.obtenerArticulo(id);
    }

    @GetMapping("/lista")
    public List<Articulo> listarArticulos(){
        return articuloService.listarArticulos();
    }


    @PostMapping("/nuevoarticulo")
    @ResponseBody
    public HttpStatus creaArticulo(HttpEntity<String> request) throws JsonProcessingException {
        //articuloService.crearArticulo(gson.fromJson(request.getBody(),Articulo.class));
        articuloService.crearArticulo(mapper.readValue(request.getBody(),Articulo.class));
        return HttpStatus.OK;

        //articuloService.crearArticulo(descripcion,costo,margenDeGanancia);
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String healthCheck(){
        return "Funciona";
    }

}
