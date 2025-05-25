package com.ramos.springboot_outlet.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String codigo;
    @NotBlank
    private String nombre;
    private String descripcion;
    @NotNull
    private BigDecimal precio;
    private String categoria;
    private String genero;

    @ManyToOne(targetEntity = Proveedor.class)
    private Proveedor proveedor;

    //@ManyToOne(targetEntity = DetalleVenta.class)
    //private DetalleVenta detalle_venta;

    @OneToMany(targetEntity = DetalleVenta.class, fetch = FetchType.LAZY, mappedBy = "producto")
    private List<DetalleVenta> detalleVentas;
}
