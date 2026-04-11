/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.biblioteca.controller;


/**
 *
 * @author erikk
 */
import br.com.biblioteca.model.Usuario;
import br.com.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String logar(String email, String senha) {

        Usuario u = service.login(email, senha);

        if (u != null) {
            return "redirect:/menu";
        }

        return "login";
    }

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }
}
