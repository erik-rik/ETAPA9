/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.biblioteca.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author erikk
 */
import br.com.biblioteca.model.Emprestimo;
import br.com.biblioteca.model.Livro;
import br.com.biblioteca.model.Usuario;
import br.com.biblioteca.service.EmprestimoService;
import br.com.biblioteca.service.UsuarioService;
import br.com.biblioteca.service.LivroService;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService service;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private LivroService livroService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("lista", service.listar());
        return "listaEmprestimos";
    }

    @GetMapping("/novo")
    public String novo(Model model) {

        Emprestimo e = new Emprestimo();
        e.setUsuario(new Usuario());
        e.setLivro(new Livro());     

        model.addAttribute("emprestimo", e);
        model.addAttribute("usuarios", usuarioService.listar());
        model.addAttribute("livros", livroService.listar());

        return "cadastroEmprestimo";
    }

    @PostMapping("/salvar")
    public String salvar(
            @RequestParam int usuarioId,
            @RequestParam int livroId,
            @RequestParam String dataEmprestimo,
            @RequestParam(required = false) Integer id
    ) {

        Emprestimo e = new Emprestimo();

        if (id != null) {
            e.setId(id);
        }

        Usuario usuario = usuarioService.buscarPorId(usuarioId);
        Livro livro = livroService.buscarPorId(livroId);

        e.setUsuario(usuario);
        e.setLivro(livro);
        e.setDataEmprestimo(LocalDate.parse(dataEmprestimo));

        service.salvar(e);

        return "redirect:/emprestimos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Emprestimo e = service.buscarPorId(id);

        if (e == null) {
            return "redirect:/emprestimos";
        }

        model.addAttribute("emprestimo", e);
        model.addAttribute("usuarios", usuarioService.listar());
        model.addAttribute("livros", livroService.listar());

        return "cadastroEmprestimo";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        service.excluir(id);
        return "redirect:/emprestimos";
    }
}
