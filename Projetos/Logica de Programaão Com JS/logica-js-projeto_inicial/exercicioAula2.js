let diaDaSemana = prompt('Que dia é hoje?');
if(diaDaSemana == 'Sábado' || diaDaSemana == 'Domingo'){
    alert('Bom fim de semana!');
}else{
    alert('Boa Semana!');
}

let numero = prompt('Digite um numero');
if(numero >= 0){
    alert('Número positivo');
}else{
    alert('Número negativo')
}

let pontos = 100;
if(pontos >= 100){
    alert('Parabéns, você venceu!')
}else{
    alert('Tente novamente para ganhar');
}

let saldo = 5000;
alert(`Saldo: ${saldo}`);

let nome = prompt('Digite Seu nome');

alert(`Seja bem vindo ${nome}`);