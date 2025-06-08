package com.ramos.springboot_outlet.controller.dto;

import com.ramos.springboot_outlet.entities.Cliente;
import com.ramos.springboot_outlet.entities.DetalleVenta;
import com.ramos.springboot_outlet.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VentaDTO {
    private Long id;
    private Long numeroVenta;
    private LocalDate diaVenta;
    private BigDecimal total;
    private String metodoPago;
    private Usuario usuario;
    private Cliente cliente;
    private DetalleVenta detalle_venta;
}
