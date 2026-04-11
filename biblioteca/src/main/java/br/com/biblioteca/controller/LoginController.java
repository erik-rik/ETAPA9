/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.biblioteca.controller;

import br.com.biblioteca.model.Usuario;
import br.com.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author erikk
 */
@Controller
public class LoginController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String email, String senha, Model model) {
        Usuario u = service.login(email, senha);

        if (u != null) {
            return "menu";
        } else {
            model.addAttribute("erro", "Login inválido");
            return "login";
        }
    }
}
