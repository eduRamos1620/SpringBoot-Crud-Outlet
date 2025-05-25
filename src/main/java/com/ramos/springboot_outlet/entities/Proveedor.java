package com.ramos.springboot_outlet.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nombre;
    private String direccion;
    @NotBlank
    @Size(min = 10, max = 13)
    private String telefono;
    private String email;

    @OneToMany(targetEntity = Producto.class, fetch = FetchType.LAZY, mappedBy = "proveedor")
    private List<Producto> productos;
}
