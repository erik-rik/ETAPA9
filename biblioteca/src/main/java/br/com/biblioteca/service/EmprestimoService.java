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
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository repo;

    public Emprestimo salvar(Emprestimo e) {
        return repo.save(e);
    }

    public List<Emprestimo> listar() {
        return repo.findAll();
    }
}
