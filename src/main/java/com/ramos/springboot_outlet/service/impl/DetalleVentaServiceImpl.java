package com.ramos.springboot_outlet.service.impl;

import com.ramos.springboot_outlet.entities.DetalleVenta;
import com.ramos.springboot_outlet.persistence.IDetalleVentaDAO;
import com.ramos.springboot_outlet.service.IDetalleVentaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleVentaServiceImpl implements IDetalleVentaService {

    private IDetalleVentaDAO service;

    @Override
    public List<DetalleVenta> findAll() {
        return service.findAll();
    }

    @Override
    public Optional<DetalleVenta> findById(Long id) {
        return service.findById(id);
    }

    @Override
    public void save(DetalleVenta detalleVenta) {
        service.save(detalleVenta);
    }

    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }
}
