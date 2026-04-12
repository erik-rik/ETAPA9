/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.biblioteca.controller;

import br.com.biblioteca.model.Livro;
import br.com.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author erikk
 */
import br.com.biblioteca.model.Livro;
import br.com.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService service;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("lista", service.listar());
        return "listaLivros";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("livro", new Livro());
        return "cadastroLivro";
    }

    @PostMapping("/salvar")
    public String salvar(Livro livro) {
        service.salvar(livro);
        return "redirect:/livros";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Livro l = service.buscarPorId(id);
        if (l == null) return "redirect:/livros";

        model.addAttribute("livro", l);
        return "cadastroLivro";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        service.excluir(id);
        return "redirect:/livros";
    }
}
