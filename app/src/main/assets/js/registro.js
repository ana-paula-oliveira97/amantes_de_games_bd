let n = document.getElementById('name');
let e = document.getElementById('email');
let s = document.getElementById('password');


let form = document.querySelector("form");

let result = document.getElementById('result');


form.onsubmit = (event) => {
  event.preventDefault();
 Chamada.envia(n.value, e.value,s.value)
 // location.href = './mostrar.html'
};

function consulta(){
 result.value =  Chamada.getResult()
}