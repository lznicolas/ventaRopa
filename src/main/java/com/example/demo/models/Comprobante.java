package com.example.demo.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Comprobante {
    private Long id;
    /*Fecha de alta sera utilizada cuando se imprima el
    * comprobante*/
    private LocalDateTime fechaAlta;
    private Venta venta;
    private TipoComprobante tipoComprobante;

    public Comprobante() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public TipoComprobante getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(TipoComprobante tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    @Override
    public String toString() {
        return "Comprobante{" +
                "id=" + id +
                ", fechaAlta=" + fechaAlta +
                ", venta=" + venta +
                ", tipoComprobante=" + tipoComprobante +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comprobante that = (Comprobante) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
