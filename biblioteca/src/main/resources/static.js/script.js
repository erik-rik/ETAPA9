/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */


function validarLogin() {
    let email = document.getElementById("email").value;
    let senha = document.getElementById("senha").value;

    if (email === "" || senha === "") {
        alert("Preencha todos os campos!");
        return false;
    }
    return true;
}

function validarUsuario() {
    let nome = document.querySelector("input[name='nome']").value;
    let email = document.querySelector("input[name='email']").value;

    if (nome === "" || email === "") {
        alert("Preencha todos os campos!");
        return false;
    }
    return true;
}

function validarLivro() {
    let titulo = document.querySelector("input[name='titulo']").value;

    if (titulo === "") {
        alert("Informe o título!");
        return false;
    }
    return true;
}

function validarEmprestimo() {
    let usuario = document.querySelector("input[name='usuario.id']").value;
    let livro = document.querySelector("input[name='livro.id']").value;

    if (usuario === "" || livro === "") {
        alert("Preencha usuário e livro!");
        return false;
    }
    return true;
}