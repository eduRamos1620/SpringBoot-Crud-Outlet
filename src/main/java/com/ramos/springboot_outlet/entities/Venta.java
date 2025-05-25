package com.ramos.springboot_outlet.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ventas")
public class Venta {

    private Long id;
    private Long numeroVenta;
    private Date diaVenta;
    private BigDecimal total;
    private String metodoPago;

}
