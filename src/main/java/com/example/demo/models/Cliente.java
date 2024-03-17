package com.example.demo.models;

import com.example.demo.models.enumeradores.CondiconTributaria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
public class Cliente extends Persona{
    private CondiconTributaria condiconTributaria;

    public Cliente() {
    }

    public Cliente(Integer id, String cuil, String apellido, String nombre, Direccion direccion, CondiconTributaria condiconTributaria) {
        super(id, cuil, apellido, nombre, direccion);
        this.condiconTributaria = condiconTributaria;
    }

    public CondiconTributaria getCondiconTributaria() {
        return condiconTributaria;
    }

    public void setCondiconTributaria(CondiconTributaria condiconTributaria) {
        this.condiconTributaria = condiconTributaria;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "condiconTributaria=" + condiconTributaria +
                '}';
    }
}
