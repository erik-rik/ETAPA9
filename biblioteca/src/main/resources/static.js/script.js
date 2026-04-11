/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */


function validarLogin() {
    let email = document.getElementById("email");
    let senha = document.getElementById("senha");

    if (!email || !senha || email.value === "" || senha.value === "") {
        alert("Preencha todos os campos!");
        return false;
    }
    return true;
}

function validarUsuario() {
    let nome = document.querySelector("input[name='nome']");
    let email = document.querySelector("input[name='email']");

    if (!nome || !email || nome.value === "" || email.value === "") {
        alert("Preencha todos os campos!");
        return false;
    }
    return true;
}

document.addEventListener("DOMContentLoaded", function () {

    const formLivro = document.getElementById("bookForm");

    if (formLivro) {
        formLivro.addEventListener("submit", function (e) {

            let valido = true;

            const autor = document.getElementById("autor");
            const titulo = document.getElementById("titulo");
            const ano = document.getElementById("ano");
            const categoria = document.getElementById("categoria");
            const quantidade = document.getElementById("quantidade");

            document.querySelectorAll(".error-message").forEach(el => el.textContent = "");

            if (!autor || autor.value.length < 2) {
                mostrarErro("autorError", "Autor inválido");
                valido = false;
            }

            if (!titulo || titulo.value.length < 2) {
                mostrarErro("tituloError", "Título inválido");
                valido = false;
            }

            if (!ano || ano.value < 1800 || ano.value > 2026) {
                mostrarErro("anoError", "Ano inválido");
                valido = false;
            }

            if (!categoria || !categoria.value) {
                mostrarErro("categoriaError", "Selecione uma categoria");
                valido = false;
            }

            if (!quantidade || quantidade.value <= 0) {
                mostrarErro("quantidadeError", "Quantidade inválida");
                valido = false;
            }

            if (!valido) {
                e.preventDefault();
            }
        });
    }

    function mostrarErro(id, mensagem) {
        const el = document.getElementById(id);
        if (el) el.textContent = mensagem;
    }

});

function validarEmprestimo() {
    let usuario = document.querySelector("input[name='usuario.id']");
    let livro = document.querySelector("input[name='livro.id']");

    if (!usuario || !livro || usuario.value === "" || livro.value === "") {
        alert("Preencha usuário e livro!");
        return false;
    }
    return true;
}