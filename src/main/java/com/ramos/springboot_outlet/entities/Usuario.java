package com.ramos.springboot_outlet.entities;

import jakarta.persistence.*;
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
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String username;
    @NotBlank
    private String nombre;
    @NotBlank
    @Column(name = "apellido_paterno")
    private String apelldioPaterno;
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    @NotBlank
    @Size(min = 10, max = 13)
    private String telefono;

    @OneToMany(targetEntity = Venta.class, fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<Venta> ventas;
}
