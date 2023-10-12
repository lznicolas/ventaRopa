
package com.example.demo.controllers;

import com.example.demo.models.talle;
import com.example.demo.services.talleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/talle")
public class TalleController {
    //----------Declaracion de variables INI------------
    @Autowired
    private talleService talleService;
    @Autowired
    ObjectMapper mapper;
    //---------Declacarion de variables FIN ------------

    //---------Listado de talle ------------------------
    @GetMapping("/lista")
    public List<talle> listartalles(){
        return talleService.listartalles();
    }

    //--------Muestra una talle ------------------------
    @GetMapping("/lista/{id}")
    public talle obtenertalle(@PathVariable Long id){
        return talleService.obtenertalle(id);
    }

    //--------Crea talle -------------------------------
    @PostMapping("/nuevatalle")
    @ResponseBody
    public HttpStatus creaArticulo(HttpEntity<String> request) throws JsonProcessingException {
        talleService.creartalle(mapper.readValue(request.getBody(),talle.class));
        return HttpStatus.OK;

        //articuloService.crearArticulo(descripcion,costo,margenDeGanancia);
    }

    @DeleteMapping("/borrar/{id}")
    public void borrartalle(@PathVariable Long id){
        talleService.borrartalle(id);
    }

    @PutMapping("/actualiza/{id}")
    public void actualizatalle(@PathVariable Long id, @RequestBody talle talle){
        talleService.actualizatalle(id, talle);
    }

}
