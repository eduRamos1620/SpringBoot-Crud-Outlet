package com.ramos.springboot_outlet.controller.dto;

import com.ramos.springboot_outlet.entities.DetalleVenta;
import com.ramos.springboot_outlet.entities.Proveedor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDTO {
    private Long id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private String categoria;
    private Proveedor proveedor;
    private List<DetalleVenta> detalleVentas;
}
