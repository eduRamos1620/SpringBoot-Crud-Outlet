package com.ramos.springboot_outlet.controller;

import com.ramos.springboot_outlet.controller.dto.UsuarioDTO;
import com.ramos.springboot_outlet.entities.Usuario;
import com.ramos.springboot_outlet.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService service;

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Usuario> usuarioOptional = service.findById(id);

        if (usuarioOptional.isPresent()){
            Usuario usuario = usuarioOptional.get();

            UsuarioDTO usuarioDTO = UsuarioDTO.builder()
                    .id(usuario.getId())
                    .username(usuario.getUsername())
                    .nombre(usuario.getNombre())
                    .apelldioPaterno(usuario.getApelldioPaterno())
                    .apellidoMaterno(usuario.getApellidoMaterno())
                    .telefono(usuario.getTelefono())
                    .build();

            return ResponseEntity.ok(usuarioDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/buscarTodo")
    public ResponseEntity<?> findAll(){
        List<UsuarioDTO> usuarios = service.findAll()
                .stream()
                .map(usuario -> UsuarioDTO.builder()
                        .id(usuario.getId())
                        .username(usuario.getUsername())
                        .nombre(usuario.getNombre())
                        .apelldioPaterno(usuario.getApelldioPaterno())
                        .apellidoMaterno(usuario.getApellidoMaterno())
                        .telefono(usuario.getTelefono())
                        .build())
                .toList();

        return ResponseEntity.ok(usuarios);
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> save(@RequestBody UsuarioDTO usuarioDTO) throws URISyntaxException {
        if (usuarioDTO.getUsername().isBlank() && usuarioDTO.getNombre().isBlank() && usuarioDTO.getTelefono().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        service.save(Usuario.builder()
                .username(usuarioDTO.getUsername())
                .nombre(usuarioDTO.getNombre())
                .apelldioPaterno(usuarioDTO.getApelldioPaterno())
                .apellidoMaterno(usuarioDTO.getApellidoMaterno())
                .telefono(usuarioDTO.getTelefono())
                .build());

        return ResponseEntity.created(new URI("/api/usuario/guardar")).build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO){
        Optional<Usuario> usuarioOptional = service.findById(id);

        if (usuarioOptional.isPresent()){
            Usuario usuario = usuarioOptional.get();

            usuario.setUsername(usuarioDTO.getUsername());
            usuario.setNombre(usuarioDTO.getNombre());
            usuario.setApelldioPaterno(usuarioDTO.getApelldioPaterno());
            usuario.setApellidoMaterno(usuarioDTO.getApellidoMaterno());
            usuario.setTelefono(usuarioDTO.getTelefono());

            service.save(usuario);

            return ResponseEntity.ok("Usuario actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        if (id != null){
            service.deleteById(id);
            return ResponseEntity.ok("Usuario eliminado");
        }
        return ResponseEntity.notFound().build();
    }
}
