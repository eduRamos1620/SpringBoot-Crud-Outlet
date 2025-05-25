package com.ramos.springboot_outlet.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long numeroVenta;
    @Column(name = "dia_venta")
    private Date diaVenta;
    private BigDecimal total;
    @Column(name = "metodo_pago")
    private String metodoPago;

    @ManyToOne(targetEntity = Usuario.class)
    private Usuario usuario;

    @ManyToOne(targetEntity = Cliente.class)
    private Cliente cliente;

    @OneToMany(targetEntity = DetalleVenta.class, fetch = FetchType.LAZY, mappedBy = "venta")
    private List<DetalleVenta> detalleVentas;
}
