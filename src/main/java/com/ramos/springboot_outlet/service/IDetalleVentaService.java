package com.ramos.springboot_outlet.service;

import com.ramos.springboot_outlet.entities.DetalleVenta;

import java.util.List;
import java.util.Optional;

public interface IDetalleVentaService {

    List<DetalleVenta> findAll();

    Optional<DetalleVenta> findById(Long id);

    void save(DetalleVenta detalleVenta);

    void deleteById(Long id);
}
