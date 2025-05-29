package com.ramos.springboot_outlet.controller;

import com.ramos.springboot_outlet.controller.dto.ProveedorDTO;
import com.ramos.springboot_outlet.entities.Proveedor;
import com.ramos.springboot_outlet.service.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proveedor")
public class ProveedorController {

    @Autowired
    private IProveedorService service;

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Proveedor> optionalProveedor = service.findById(id);

        if (optionalProveedor.isPresent()){
            Proveedor proveedor = optionalProveedor.get();

            ProveedorDTO proveedorDTO = ProveedorDTO.builder()
                    .id(proveedor.getId())
                    .nombre(proveedor.getNombre())
                    .direccion(proveedor.getDireccion())
                    .telefono(proveedor.getTelefono())
                    .email(proveedor.getEmail())
                    .productos(proveedor.getProductos())
                    .build();

            return ResponseEntity.ok(proveedorDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/buscarTodo")
    public ResponseEntity<?> findAll(){
        List<ProveedorDTO> proveedores = service.findAll()
                .stream()
                .map(proveedor -> ProveedorDTO.builder()
                        .id(proveedor.getId())
                        .nombre(proveedor.getNombre())
                        .direccion(proveedor.getDireccion())
                        .telefono(proveedor.getTelefono())
                        .email(proveedor.getEmail())
                        .productos(proveedor.getProductos())
                        .build()
                ).toList();

        return ResponseEntity.ok(proveedores);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProveedorDTO proveedorDTO) throws URISyntaxException {
        if (proveedorDTO.getNombre().isBlank() && proveedorDTO.getTelefono().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        service.save(Proveedor.builder()
                .nombre(proveedorDTO.getNombre())
                .direccion(proveedorDTO.getDireccion())
                .telefono(proveedorDTO.getTelefono())
                .email(proveedorDTO.getEmail())
                .build());

        return ResponseEntity.created(new URI("/api/proveedor/save")).build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProveedorDTO proveedorDTO){
        Optional<Proveedor> optionalProveedor = service.findById(id);

        if (optionalProveedor.isPresent()){
            Proveedor proveedor = optionalProveedor.get();
            proveedor.setNombre(proveedorDTO.getNombre());
            proveedor.setDireccion(proveedorDTO.getDireccion());
            proveedor.setTelefono(proveedorDTO.getTelefono());
            proveedor.setEmail(proveedorDTO.getEmail());

            service.save(proveedor);

            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if (id != null){
            service.deleteById(id);
            return ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.notFound().build();
    }
}
