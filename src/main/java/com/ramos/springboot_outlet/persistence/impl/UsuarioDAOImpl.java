package com.ramos.springboot_outlet.persistence.impl;

import com.ramos.springboot_outlet.entities.Usuario;
import com.ramos.springboot_outlet.persistence.IUsuarioDAO;
import com.ramos.springboot_outlet.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UsuarioDAOImpl implements IUsuarioDAO {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) repository.findAll();
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Usuario usuario) {
        repository.save(usuario);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
