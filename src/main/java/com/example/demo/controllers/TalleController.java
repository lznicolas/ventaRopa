
package com.example.demo.controllers;

import com.example.demo.models.Marca;
import com.example.demo.models.Talle;
import com.example.demo.services.implementations.TalleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/talle")
public class TalleController {
    //----------Declaracion de variables INI------------
    @Autowired
    private TalleService talleService;
    @Autowired
    ObjectMapper mapper;
    //---------Declacarion de variables FIN ------------

    //---------Listado de talle ------------------------
    @GetMapping("/lista")
    public Iterable<Talle> findAll(){
        return talleService.findAll();
    }

    //--------Muestra una talle ------------------------
    @GetMapping("/lista/{id}")
    public Optional<Talle> findById (@PathVariable Long id){
        return talleService.findById(id);
    }

    //--------Crea talle -------------------------------
    @PostMapping("/nuevatalle")
    @ResponseBody
    public Talle crearTalle(Talle talle){
        return talleService.save(talle);
    }

    @DeleteMapping("/borrar/{id}")
    public void borrartalle(@PathVariable Long id){
        talleService.deleteById(id);
    }

    @PutMapping("/actualiza/{id}")
    public void actualizatalle(@PathVariable Long id, @RequestBody Talle talle){
        talleService.actualiza(id, talle);
    }

}
