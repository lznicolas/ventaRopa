package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
public class Cliente extends Persona{
    private CondicionTributaria condicionTributaria;
    public Cliente() {
    }

    public Cliente(Integer id, String cuil, String apellido, String nombre, Direccion direccion) {
        super(id, cuil, apellido, nombre, direccion);
    }

    public CondicionTributaria getCondicionTributaria() {
        return condicionTributaria;
    }

    public void setCondicionTributaria(CondicionTributaria condicionTributaria) {
        this.condicionTributaria = condicionTributaria;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "condicionTributaria=" + condicionTributaria +
                '}';
    }
}
