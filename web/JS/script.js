// Script Menu
function abreMenu() {
  document.querySelector(".menu-nav").style.width = "300px";
}

function fechaMenu() {
  document.querySelector(".menu-nav").style.width = "0";
}


// Script Máscara dos campos
jQuery(function ($) {
  $("#data").mask("99/99/9999");
  $("#date").mask("99/99/9999");
  $("#entrega").mask("99/99/9999");
  $("#cel").mask("(99) 99999-9999");
  $("#telefone").mask("(99) 9999-9999");
  $("#cpf").mask("999.999.999-99");
  //$("#cep").mask("99999-999"); 
  //$("#cnpj").mask("99.999.999/9999-99");

});

