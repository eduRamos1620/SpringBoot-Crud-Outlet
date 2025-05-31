package com.ramos.springboot_outlet.controller.dto;

import com.ramos.springboot_outlet.entities.Venta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTO {
    private Long id;
    private String username;
    private String nombre;
    private String apelldioPaterno;
    private String apellidoMaterno;
    private String telefono;
    private List<Venta> ventas;
}
