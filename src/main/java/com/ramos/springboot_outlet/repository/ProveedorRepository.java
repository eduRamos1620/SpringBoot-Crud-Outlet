package com.ramos.springboot_outlet.repository;

import com.ramos.springboot_outlet.entities.Proveedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends CrudRepository<Proveedor, Long> {
}
