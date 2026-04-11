/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.biblioteca.controller;


/**
 *
 * @author erikk
 */
import br.com.biblioteca.model.User;
import br.com.biblioteca.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UserService service;

    // TELA DE LOGIN
    @GetMapping("/")
    public String login() {
        return "login";
    }

    // PROCESSA LOGIN
    @PostMapping("/login")
    public String logar(@RequestParam String email,
                        @RequestParam String senha) {

        User u = service.login(email, senha);

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
