let name = document.getElementById('name');
let email = document.getElementById('email');
let senha = document.getElementById('password');

let form = document.querySelector("form");

form.onsubmit = (event) => {
  event.preventDefault();
 Chamada.envia(name.value, email.value,telefone.value, senha.value)
   location.href = "./index.html";
};

function s(){
Chamada.consultar()
}

