package com.ramos.springboot_outlet.service.impl;

import com.ramos.springboot_outlet.entities.Producto;
import com.ramos.springboot_outlet.persistence.IProductoDAO;
import com.ramos.springboot_outlet.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private IProductoDAO service;

    @Override
    public List<Producto> findAll() {
        return service.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return service.findById(id);
    }

    @Override
    public void save(Producto producto) {
        service.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }
}
