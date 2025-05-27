package com.ramos.springboot_outlet.service;

import com.ramos.springboot_outlet.entities.Venta;

import java.util.List;
import java.util.Optional;

public interface IVenteService {

    List<Venta> findAll();

    Optional<Venta> findById(Long id);

    void save(Venta venta);

    void deleteById(Long id);
}
