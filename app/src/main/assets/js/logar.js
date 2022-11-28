let Email = document.getElementById("email");
let Password = document.getElementById("password");

let form = document.querySelector("form");
let a = document.querySelector("#inicio");

let logado = null;
let interval1 = null;

setInterval(() => {
  if (Ponte.getLogin() != logado) {
    logado = Ponte.getLogin();
  }
}, 500);

form.addEventListener("submit", function (event) {
  event.preventDefault();
  try {
    Ponte.validaUsuario(Email.value, Password.value);

    interval1 = setInterval(() => {
      if (logado) {
        // Seting User

        location.href = "./noticias.html";
      } else {
        alert("No logado");
      }
      clearInterval(interval1);
    }, 850);
  } catch {
    alert("Erro de comunicação entre Js com o Java");
  }
});
