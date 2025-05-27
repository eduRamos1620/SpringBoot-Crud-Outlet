package com.ramos.springboot_outlet.persistence.impl;

import com.ramos.springboot_outlet.entities.Proveedor;
import com.ramos.springboot_outlet.persistence.IProveedorDAO;
import com.ramos.springboot_outlet.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProveedorDAOImpl implements IProveedorDAO {

    @Autowired
    private ProveedorRepository repository;

    @Override
    public List<Proveedor> findAll() {
        return (List<Proveedor>) repository.findAll();
    }

    @Override
    public Optional<Proveedor> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Proveedor proveedor) {
        repository.save(proveedor);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
