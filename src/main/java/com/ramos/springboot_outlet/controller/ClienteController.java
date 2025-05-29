package com.ramos.springboot_outlet.controller;

import com.ramos.springboot_outlet.controller.dto.ClienteDTO;
import com.ramos.springboot_outlet.entities.Cliente;
import com.ramos.springboot_outlet.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private IClienteService service;

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Cliente> clienteOptional = service.findById(id);

        if (clienteOptional.isPresent()){
            Cliente cliente = clienteOptional.get();

            ClienteDTO clienteDTO = ClienteDTO.builder()
                    .id(cliente.getId())
                    .nombre(cliente.getNombre())
                    .apellidoPaterno(cliente.getApellidoPaterno())
                    .apellidoMaterno(cliente.getApellidoMaterno())
                    .telefono(cliente.getTelefono())
                    .genero(cliente.getGenero())
                    .build();

            return ResponseEntity.ok(clienteDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/buscarTodo")
    public ResponseEntity<?> findAll(){
        List<ClienteDTO> clientes = service.findAll()
                .stream()
                .map(cliente ->ClienteDTO.builder()
                        .id(cliente.getId())
                        .nombre(cliente.getNombre())
                        .apellidoPaterno(cliente.getApellidoPaterno())
                        .apellidoMaterno(cliente.getApellidoMaterno())
                        .telefono(cliente.getTelefono())
                        .genero(cliente.getGenero())
                        .build())
                .toList();

        return ResponseEntity.ok(clientes);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ClienteDTO clienteDTO) throws URISyntaxException {

        if (clienteDTO.getNombre().isBlank() && clienteDTO.getApellidoPaterno().isBlank() && clienteDTO.getTelefono().isBlank()){
                return ResponseEntity.badRequest().build();
        }

        service.save(Cliente.builder()
                .nombre(clienteDTO.getNombre())
                .apellidoPaterno(clienteDTO.getApellidoPaterno())
                .apellidoMaterno(clienteDTO.getApellidoMaterno())
                .telefono(clienteDTO.getTelefono())
                .genero(clienteDTO.getGenero())
                .build());

        return ResponseEntity.created(new URI("/api/cliente/save")).build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO){
        Optional<Cliente> clienteOptional = service.findById(id);

        if (clienteOptional.isPresent()){
            Cliente cliente = clienteOptional.get();
            cliente.setNombre(clienteDTO.getNombre());
            cliente.setApellidoPaterno(clienteDTO.getApellidoPaterno());
            cliente.setApellidoMaterno(clienteDTO.getApellidoMaterno());
            cliente.setTelefono(clienteDTO.getTelefono());
            cliente.setGenero(clienteDTO.getGenero());

            service.save(cliente);

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
