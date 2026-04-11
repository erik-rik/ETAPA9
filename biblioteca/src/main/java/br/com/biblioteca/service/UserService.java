/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.biblioteca.service;


/**
 *
 * @author erikk
 */
import br.com.biblioteca.model.User;
import br.com.biblioteca.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User login(String email, String senha) {
        return repository.findByEmailAndSenha(email, senha);
    }
}
