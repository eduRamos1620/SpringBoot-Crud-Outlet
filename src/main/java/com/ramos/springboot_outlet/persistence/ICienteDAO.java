package com.ramos.springboot_outlet.persistence;

import com.ramos.springboot_outlet.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface ICienteDAO {

    List<Cliente> findAll();

    Optional<Cliente> findById(Long id);

    void save(Cliente cliente);

    void deleteById(Long id);
}
