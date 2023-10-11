package com.example.demo.services.contracts;

import java.util.Optional;

public interface GenericDAO<E>{
    Optional<E> findById(Long id);
    E save(E entidad);
    Iterable<E> findAll();
    void deleteById(Long id);
    E actualiza(Long id,E entidad);
}
