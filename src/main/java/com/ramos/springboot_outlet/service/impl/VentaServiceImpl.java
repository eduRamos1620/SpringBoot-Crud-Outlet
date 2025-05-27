package com.ramos.springboot_outlet.service.impl;

import com.ramos.springboot_outlet.entities.Venta;
import com.ramos.springboot_outlet.persistence.IVentaDAO;
import com.ramos.springboot_outlet.service.IVenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaServiceImpl implements IVenteService {

    @Autowired
    private IVentaDAO service;

    @Override
    public List<Venta> findAll() {
        return service.findAll();
    }

    @Override
    public Optional<Venta> findById(Long id) {
        return service.findById(id);
    }

    @Override
    public void save(Venta venta) {
        service.save(venta);
    }

    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }
}
