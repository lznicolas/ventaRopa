package com.example.demo.controllers;


import com.example.demo.models.Articulo;
import com.example.demo.models.Marca;
import com.example.demo.services.MarcaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Marca> listarMarcas(){
        return marcaService.listarMarcas();
    }

    //--------Muestra una Marca ------------------------
    @GetMapping("/lista/{id}")
    public Marca obtenerMarca(@PathVariable Long id){
        return marcaService.obtenerMarca(id);
    }

    //--------Crea Marca -------------------------------
    @PostMapping("/nuevamarca")
    @ResponseBody
    public HttpStatus creaArticulo(HttpEntity<String> request) throws JsonProcessingException {
        marcaService.crearMarca(mapper.readValue(request.getBody(),Marca.class));
        return HttpStatus.OK;

        //articuloService.crearArticulo(descripcion,costo,margenDeGanancia);
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarMarca(@PathVariable Long id){
        marcaService.borrarMarca(id);
    }

    @PutMapping("/actualiza/{id}")
    public void actualizaMarca(@PathVariable Long id, @RequestBody Marca marca){
        marcaService.actualizaMarca(id, marca);
    }

}
