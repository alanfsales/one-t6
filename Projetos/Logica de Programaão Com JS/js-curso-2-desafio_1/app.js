let titulo = document.querySelector('h1');

titulo.innerHTML = 'Hora do Desafio';

function cliqueBotaoConsole(){
    console.log('O botão foi clicado!');
}

function cliqueBotaoAlert(){
    alert('Eu amo JS!');
}

function cliqueBotaoPrompt(){
    let cidade = prompt('Digite o nome de uma Cidade do Brasil.');
    alert(`Estive em ${cidade} e lembrei de você.`);
}

function cliqueBotaoSoma(){
    let numero1 = prompt('Digite um número.');
    let numero2 = prompt('Digite outro número.');

    let soma = Number.parseInt(numero1) + Number.parseInt(numero2);

    alert(soma);
}