package com.ramos.springboot_outlet.service;

import com.ramos.springboot_outlet.entities.Proveedor;

import java.util.List;
import java.util.Optional;

public interface IProveedorService {

   List<Proveedor> findAll();

   Optional<Proveedor> findById(Long id);

   void save(Proveedor proveedor);

   void deleteById(Long id);
}
