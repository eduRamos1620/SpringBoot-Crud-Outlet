package com.ramos.springboot_outlet.service.impl;

import com.ramos.springboot_outlet.entities.Usuario;
import com.ramos.springboot_outlet.persistence.IUsuarioDAO;
import com.ramos.springboot_outlet.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioDAO service;

    @Override
    public List<Usuario> findAll() {
        return service.findAll();
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return service.findById(id);
    }

    @Override
    public void save(Usuario usuario) {
        service.save(usuario);
    }

    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }
}
