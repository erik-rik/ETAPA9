/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.biblioteca.service;



/**
 *
 * @author erikk
 */
import br.com.biblioteca.model.Emprestimo;
import br.com.biblioteca.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository repo;

    public void salvar(Emprestimo e) {
        repo.save(e);
    }

    public List<Emprestimo> listar() {
        return repo.findAll();
    }

    public Emprestimo buscarPorId(int id) {
        return repo.findById(id).orElse(null);
    }

    public void excluir(int id) {
        repo.deleteById(id);
    }
}
