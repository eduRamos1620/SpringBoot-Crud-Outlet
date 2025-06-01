package com.ramos.springboot_outlet.controller.dto;

import com.ramos.springboot_outlet.entities.Producto;
import com.ramos.springboot_outlet.entities.Venta;
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
public class DetalleVentaDTO {
    private Long id;
    private int cantidad;
    private BigDecimal subtotal;
    private Producto producto;
    private List<Venta> ventas;
}
