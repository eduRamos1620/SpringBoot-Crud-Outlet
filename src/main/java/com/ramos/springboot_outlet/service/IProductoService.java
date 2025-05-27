package com.ramos.springboot_outlet.service;

import com.ramos.springboot_outlet.entities.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {

    List<Producto> findAll();

    Optional<Producto> findById(Long id);

    void save(Producto producto);

    void deleteById(Long id);
}
