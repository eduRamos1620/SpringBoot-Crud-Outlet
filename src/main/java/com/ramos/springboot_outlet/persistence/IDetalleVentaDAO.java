package com.ramos.springboot_outlet.persistence;

import com.ramos.springboot_outlet.entities.DetalleVenta;

import java.util.List;
import java.util.Optional;

public interface IDetalleVentaDAO {

    List<DetalleVenta> findAll();

    Optional<DetalleVenta> findById(Long id);

    void save(DetalleVenta detalleVenta);

    void deleteById(Long id);
}
