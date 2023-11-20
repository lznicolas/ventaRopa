package com.example.demo.repositories;

import com.example.demo.models.Talle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TalleRepository extends CrudRepository<Talle, Long> {
}
