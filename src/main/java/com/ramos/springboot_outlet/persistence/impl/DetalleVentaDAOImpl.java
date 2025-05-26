package com.ramos.springboot_outlet.persistence.impl;

import com.ramos.springboot_outlet.entities.DetalleVenta;
import com.ramos.springboot_outlet.persistence.IDetalleVentaDAO;
import com.ramos.springboot_outlet.repository.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DetalleVentaDAOImpl implements IDetalleVentaDAO {

    @Autowired
    private DetalleVentaRepository repository;

    @Override
    public List<DetalleVenta> findAll() {
        return (List<DetalleVenta>) repository.findAll();
    }

    @Override
    public Optional<DetalleVenta> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(DetalleVenta detalleVenta) {
        repository.save(detalleVenta);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
