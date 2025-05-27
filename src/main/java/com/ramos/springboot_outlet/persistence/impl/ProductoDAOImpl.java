package com.ramos.springboot_outlet.persistence.impl;

import com.ramos.springboot_outlet.entities.Producto;
import com.ramos.springboot_outlet.persistence.IProductoDAO;
import com.ramos.springboot_outlet.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductoDAOImpl implements IProductoDAO {

    @Autowired
    private ProductoRepository repository;

    @Override
    public List<Producto> findAll() {
        return (List<Producto>) repository.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Producto producto) {
        repository.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
