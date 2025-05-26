package com.ramos.springboot_outlet.repository;

import com.ramos.springboot_outlet.entities.Venta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRespository extends CrudRepository<Venta, Long> {
}
