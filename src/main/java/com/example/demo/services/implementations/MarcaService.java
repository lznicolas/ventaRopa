package com.example.demo.services.implementations;

import com.example.demo.models.Articulo;
import com.example.demo.models.Marca;
import com.example.demo.repositories.MarcaRepository;
import com.example.demo.services.contracts.MarcaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MarcaService implements MarcaDAO {
    //----------Declaracion de variables INI------------
    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Marca> findById(Long id) {
        return marcaRepository.findById(id);
    }

    @Override
    @Transactional
    public Marca save(Marca marca) {
        return marcaRepository.save(marca);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Marca> findAll() {
        return marcaRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        marcaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Marca actualiza(Long id, Marca marca) {
        Marca marcaActulizada = marcaRepository.findById(id).get();
        marcaActulizada.setMarca(marca.getMarca());
        return marcaRepository.save(marcaActulizada);
    }


}
