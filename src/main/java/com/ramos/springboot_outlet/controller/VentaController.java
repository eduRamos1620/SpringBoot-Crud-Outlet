package com.ramos.springboot_outlet.controller;

import com.ramos.springboot_outlet.controller.dto.VentaDTO;
import com.ramos.springboot_outlet.entities.Venta;
import com.ramos.springboot_outlet.service.IVenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
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

    @PostMapping("/guardar")
    public ResponseEntity<?> save(@RequestBody VentaDTO ventaDTO) throws URISyntaxException {
        LocalDate diaVenta2 = LocalDate.now();
        if(ventaDTO.getNumeroVenta() == null){
            return ResponseEntity.badRequest().build();
        }

        service.save(Venta.builder()
                .numeroVenta(ventaDTO.getNumeroVenta())
                .diaVenta(diaVenta2)
                .total(ventaDTO.getTotal())
                .metodoPago(ventaDTO.getMetodoPago())
                .usuario(ventaDTO.getUsuario())
                .cliente(ventaDTO.getCliente())
                .detalle_venta(ventaDTO.getDetalle_venta())
                .build());

        return ResponseEntity.created(new URI("/api/venta/guardar")).build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody VentaDTO ventaDTO){
        Optional<Venta> ventaOptional = service.findById(id);

        if (ventaOptional.isPresent()){
            Venta venta = ventaOptional.get();

            venta.setNumeroVenta(ventaDTO.getNumeroVenta());
            venta.setTotal(ventaDTO.getTotal());
            venta.setMetodoPago(ventaDTO.getMetodoPago());
            venta.setUsuario(ventaDTO.getUsuario());

            service.save(venta);

            return ResponseEntity.ok("Venta actualizada");
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> deleteById(@PathVariable Long id){
        if (id != null){
            service.deleteById(id);
            return ResponseEntity.ok("Venta eliminada");
        }
        return ResponseEntity.notFound().build();
    }
}
