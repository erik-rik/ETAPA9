/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.biblioteca.service;



/**
 *
 * @author erikk
 */
import br.com.biblioteca.model.Livro;
import br.com.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repo;

    public void salvar(Livro l) {
        repo.save(l);
    }

    public List<Livro> listar() {
        return repo.findAll();
    }

    public Livro buscarPorId(int id) {
        return repo.findById(id).orElse(null);
    }

    public void excluir(int id) {
        repo.deleteById(id);
    }
}
