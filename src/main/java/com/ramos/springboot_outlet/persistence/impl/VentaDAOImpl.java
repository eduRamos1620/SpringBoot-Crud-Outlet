package com.ramos.springboot_outlet.persistence.impl;

import com.ramos.springboot_outlet.entities.Venta;
import com.ramos.springboot_outlet.persistence.IVentaDAO;
import com.ramos.springboot_outlet.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VentaDAOImpl implements IVentaDAO {

    @Autowired
    private VentaRepository repository;

    @Override
    public List<Venta> findAll() {
        return (List<Venta>) repository.findAll();
    }

    @Override
    public Optional<Venta> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Venta venta) {
        repository.save(venta);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
