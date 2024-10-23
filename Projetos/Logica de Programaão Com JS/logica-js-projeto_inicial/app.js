alert('Boas vindas ao jogo do número secreto');
let numeroMax = 100;
let numeroSecreto = parseInt(Math.random() * numeroMax + 1);
console.log(numeroSecreto);
let chute;
let tentativas = 1;

//Enquanto chute não for igual ao número secreto
while(chute != numeroSecreto){
    chute = prompt(`Escolha um número entre 1 e ${numeroMax}`);
    //Se Chute for igual ao número secreto
    if(chute == numeroSecreto){
        break;
    }else{
        if(chute > numeroSecreto ){
            alert(`O número é menor que ${chute}`);
        }else{
            alert(`O número é maior que ${chute}`);
        }
        tentativas++;
    }
}

let palavraTentativa = tentativas > 1 ? 'tentativas' : 'tentativa';
alert(`Isso ai! Você descobriu o mumero secreto é ${numeroSecreto} com ${tentativas} ${palavraTentativa}.`);


