package com.ramos.springboot_outlet.controller;

import com.ramos.springboot_outlet.controller.dto.VentaDTO;
import com.ramos.springboot_outlet.entities.Venta;
import com.ramos.springboot_outlet.service.IVenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/venta")
public class VentaController {

    @Autowired
    private IVenteService service;

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Venta> ventaOptional = service.findById(id);

        if (ventaOptional.isPresent()){
            Venta venta = ventaOptional.get();

            VentaDTO ventaDTO = VentaDTO.builder()
                    .id(venta.getId())
                    .numeroVenta(venta.getNumeroVenta())
                    .diaVenta(venta.getDiaVenta())
                    .total(venta.getTotal())
                    .metodoPago(venta.getMetodoPago())
                    .usuario(venta.getUsuario())
                    .cliente(venta.getCliente())
                    .detalle_venta(venta.getDetalle_venta())
                    .build();

            return ResponseEntity.ok(ventaDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/buscarTodo")
    public ResponseEntity<?> findAll(){
        List<VentaDTO> ventas = service.findAll()
                .stream()
                .map(venta -> VentaDTO.builder()
                        .id(venta.getId())
                        .numeroVenta(venta.getNumeroVenta())
                        .diaVenta(venta.getDiaVenta())
                        .total(venta.getTotal())
                        .metodoPago(venta.getMetodoPago())
                        .usuario(venta.getUsuario())
                        .cliente(venta.getCliente())
                        .detalle_venta(venta.getDetalle_venta())
                        .build())
                .toList();

        return ResponseEntity.ok(ventas);
    }

    public ResponseEntity<?>
}
