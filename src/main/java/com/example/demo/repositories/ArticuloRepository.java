package com.example.demo.repositories;

import com.example.demo.models.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepository extends CrudRepository<Articulo, Long> {
}
