package com.ramos.springboot_outlet.persistence.impl;

import com.ramos.springboot_outlet.entities.Cliente;
import com.ramos.springboot_outlet.persistence.ICienteDAO;
import com.ramos.springboot_outlet.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ClienteDAOImpl implements ICienteDAO {

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) repository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Cliente cliente) {
        repository.save(cliente);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
