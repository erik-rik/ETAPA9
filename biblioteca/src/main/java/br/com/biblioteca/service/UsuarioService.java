/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.biblioteca.service;



/**
 *
 * @author erikk
 */
import br.com.biblioteca.model.Usuario;
import br.com.biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    public void salvar(Usuario u) {
        repo.save(u);
    }

    public List<Usuario> listar() {
        return repo.findAll();
    }

    public Usuario buscarPorId(int id) {
        return repo.findById(id).orElse(null);
    }

    public void excluir(int id) {
        repo.deleteById(id);
    }
}
