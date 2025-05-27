package com.ramos.springboot_outlet.persistence;

import com.ramos.springboot_outlet.entities.Proveedor;

import java.util.List;
import java.util.Optional;

public interface IProveedorDAO {

    List<Proveedor> findAll();

    Optional<Proveedor> findById(Long id);

    void save(Proveedor proveedor);

    void deleteById(Long id);
}
