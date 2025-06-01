package com.ramos.springboot_outlet.controller;

import com.ramos.springboot_outlet.controller.dto.DetalleVentaDTO;
import com.ramos.springboot_outlet.entities.DetalleVenta;
import com.ramos.springboot_outlet.service.IDetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detalle_venta")
public class DetalleVentaController {

    @Autowired
    private IDetalleVentaService service;

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<DetalleVenta> detalleVentaOptional = service.findById(id);

        if (detalleVentaOptional.isPresent()){
            DetalleVenta detalleVenta = detalleVentaOptional.get();

            DetalleVentaDTO detalleVentaDTO = DetalleVentaDTO.builder()
                    .id(detalleVenta.getId())
                    .cantidad(detalleVenta.getCantidad())
                    .subtotal(detalleVenta.getSubtotal())
                    .producto(detalleVenta.getProducto())
                    .build();

            return ResponseEntity.ok(detalleVentaDTO);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/buscarTodo")
    public ResponseEntity<?> findAll(){
        List<DetalleVentaDTO> detalles = service.findAll()
                .stream()
                .map(detalleVenta -> DetalleVentaDTO.builder()
                        .id(detalleVenta.getId())
                        .cantidad(detalleVenta.getCantidad())
                        .subtotal(detalleVenta.getSubtotal())
                        .producto(detalleVenta.getProducto())
                        .build())
                .toList();

        return ResponseEntity.ok(detalles);
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> save(@RequestBody DetalleVentaDTO detalleVentaDTO) throws URISyntaxException {
        service.save(DetalleVenta.builder()
                .cantidad(detalleVentaDTO.getCantidad())
                .subtotal(detalleVentaDTO.getSubtotal())
                .producto(detalleVentaDTO.getProducto())
                .build());

        return ResponseEntity.created(new URI("/api/detalle_venta/guardar")).build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody DetalleVentaDTO detalleVentaDTO){
        Optional<DetalleVenta> detalleVentaOptional = service.findById(id);

        if (detalleVentaOptional.isPresent()){
            DetalleVenta detalleVenta = detalleVentaOptional.get();

            detalleVenta.setCantidad(detalleVentaDTO.getCantidad());
            detalleVenta.setSubtotal(detalleVentaDTO.getSubtotal());
            detalleVenta.setProducto(detalleVentaDTO.getProducto());

            service.save(detalleVenta);

            return ResponseEntity.ok("Se actualizo el datalle de la venta");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        if (id != null){
            service.deleteById(id);
            return  ResponseEntity.ok("Detalle de venta eliminado");
        }
        return  ResponseEntity.notFound().build();
    }
}
