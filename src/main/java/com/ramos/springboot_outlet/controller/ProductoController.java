package com.ramos.springboot_outlet.controller;

import com.ramos.springboot_outlet.controller.dto.ProductoDTO;
import com.ramos.springboot_outlet.entities.Producto;
import com.ramos.springboot_outlet.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private IProductoService service;

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Producto> productoOptional = service.findById(id);

        if (productoOptional.isPresent()){
            Producto producto = productoOptional.get();

            ProductoDTO productoDTO = ProductoDTO.builder()
                    .id(producto.getId())
                    .codigo(producto.getCodigo())
                    .nombre(producto.getCodigo())
                    .descripcion(producto.getDescripcion())
                    .precio(producto.getPrecio())
                    .categoria(producto.getCategoria())
                    .proveedor(producto.getProveedor())
                    .build();

            return  ResponseEntity.ok(productoDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/buscarTodo")
    public ResponseEntity<?> findAll(){
        List<ProductoDTO> productos = service.findAll()
                .stream()
                .map(producto -> ProductoDTO.builder()
                        .id(producto.getId())
                        .codigo(producto.getCodigo())
                        .nombre(producto.getNombre())
                        .descripcion(producto.getDescripcion())
                        .precio(producto.getPrecio())
                        .categoria(producto.getCategoria())
                        .proveedor(producto.getProveedor())
                        .build())
                .toList();

        return ResponseEntity.ok(productos);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> save(@RequestBody ProductoDTO productoDTO) throws URISyntaxException {
        if (productoDTO.getCodigo().isBlank() && productoDTO.getNombre().isBlank() && productoDTO.getPrecio() == null){
            return ResponseEntity.badRequest().build();
        }

        service.save(Producto.builder()
                .codigo(productoDTO.getCodigo())
                .nombre(productoDTO.getNombre())
                .descripcion(productoDTO.getDescripcion())
                .precio(productoDTO.getPrecio())
                .categoria(productoDTO.getCategoria())
                .proveedor(productoDTO.getProveedor())
                .build());

        return ResponseEntity.created(new URI("/api/producto/crear")).build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductoDTO productoDTO){
        Optional<Producto> productoOptional = service.findById(id);

        if (productoOptional.isPresent()){
            Producto producto = productoOptional.get();
            producto.setCodigo(productoDTO.getCodigo());
            producto.setNombre(productoDTO.getNombre());
            producto.setDescripcion(productoDTO.getDescripcion());
            producto.setPrecio(productoDTO.getPrecio());
            producto.setCategoria(productoDTO.getCategoria());
            producto.setProveedor(productoDTO.getProveedor());

            service.save(producto);

            return ResponseEntity.ok("Se ha actualizado el registro");
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delelte(@PathVariable Long id){
        if (id != null){
            service.deleteById(id);
            return  ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.notFound().build();
    }
}
