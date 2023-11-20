package com.example.demo.services.implementations;

import com.example.demo.models.Marca;
import com.example.demo.models.Talle;
import com.example.demo.repositories.TalleRepository;
import com.example.demo.services.contracts.TalleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

public class TalleService implements TalleDAO{
    @Autowired
    private TalleRepository talleRepository;
    @Override
    @Transactional(readOnly = true)
    public Optional<Talle> findById(Long id) {
        return talleRepository.findById(id);
    }

    @Override
    @Transactional
    public Talle save(Talle talle) {
        return talleRepository.save(talle);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Talle> findAll() {
        return talleRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        talleRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Talle actualiza(Long id, Talle talle) {
        Talle talleActulizado = talleRepository.findById(id).get();
        talleActulizado.setDescripcion(talle.getDescripcion());
        return talleRepository.save(talleActulizado);
    }
}
