package com.ramos.springboot_outlet.service.impl;

import com.ramos.springboot_outlet.entities.Proveedor;
import com.ramos.springboot_outlet.persistence.IProveedorDAO;
import com.ramos.springboot_outlet.service.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServiceImpl implements IProveedorService {

    @Autowired
    private IProveedorDAO service;

    @Override
    public List<Proveedor> findAll() {
        return service.findAll();
    }

    @Override
    public Optional<Proveedor> findById(Long id) {
        return service.findById(id);
    }

    @Override
    public void save(Proveedor proveedor) {
        service.save(proveedor);
    }

    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }
}
