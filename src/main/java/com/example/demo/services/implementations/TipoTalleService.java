package com.example.demo.services.implementations;

import com.example.demo.models.TipoTalle;
import com.example.demo.repositories.TipoTalleRepository;
import com.example.demo.services.contracts.TipoTalleDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class TipoTalleService implements TipoTalleDAO {

    @Autowired
    private TipoTalleRepository tipoTalleRepository;
    @Override
    public Optional<TipoTalle> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public TipoTalle save(TipoTalle entidad) {
        return null;
    }

    @Override
    public Iterable<TipoTalle> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public TipoTalle actualiza(Long id, TipoTalle entidad) {
        return null;
    }
}
