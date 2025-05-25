package com.ramos.springboot_outlet.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {

    private Long id;
    private int cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subtotal;
}
