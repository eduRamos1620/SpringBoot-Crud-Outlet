package com.ramos.springboot_outlet.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cantidad;
    //@Column(name = "precio_unitarrio")
    //private BigDecimal precioUnitario;
    private BigDecimal subtotal;

    @OneToMany(targetEntity = Producto.class, fetch = FetchType.LAZY, mappedBy = "detalle_venta")
    private List<Producto> productos;

    @ManyToOne(targetEntity = Venta.class)
    private Venta venta;
}
