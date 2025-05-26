package com.ramos.springboot_outlet.repository;

import com.ramos.springboot_outlet.entities.DetalleVenta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleVentaRepository extends CrudRepository<DetalleVenta, Long> {
}
