package com.ramos.springboot_outlet.service;

import com.ramos.springboot_outlet.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {

    List<Cliente> findAll();

    Optional<Cliente> findById(Long id);

    void save(Cliente cliente);

    void deleteById(Long id);
}
