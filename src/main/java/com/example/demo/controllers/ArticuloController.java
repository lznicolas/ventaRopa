package com.example.demo.controllers;

import com.example.demo.models.Articulo;
import com.example.demo.repositories.ArticuloRepository;
import com.example.demo.services.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articulos")
public class ArticuloController {
    @Autowired
    private ArticuloService articuloService;

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
    public void creaArticulo(@RequestBody String descripcion, Double costo, Double margenDeGanancia){
        articuloService.crearArticulo(descripcion,costo,margenDeGanancia);
    }


}
