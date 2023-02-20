const miTextArea = document.getElementById("ValoracionTextArea");
const contadorLetras = document.getElementById("contadorLetras");

miTextArea.addEventListener("input", function() {
  const texto = this.value;
  const numLetras = texto.length;
  const letrasRestantes = 500 - numLetras;
  contadorLetras.innerHTML = `Caracteres restantes: ${letrasRestantes}`;
});