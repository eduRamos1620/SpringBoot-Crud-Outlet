package com.ramos.springboot_outlet.service.impl;

import com.ramos.springboot_outlet.entities.Cliente;
import com.ramos.springboot_outlet.persistence.ICienteDAO;
import com.ramos.springboot_outlet.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ICienteDAO service;

    @Override
    public List<Cliente> findAll() {
        return service.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return service.findById(id);
    }

    @Override
    public void save(Cliente cliente) {
        service.save(cliente);
    }

    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }
}
