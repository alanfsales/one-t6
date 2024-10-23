let raqueteJogador, raqueteComputador, bola;
let jogadorY, computadorY;
let bolaX, bolaY, velocidadeBolaX, velocidadeBolaY;
let velocidadeRaqueteComputador = 5; // Velocidade de movimento da raquete do computador
let alturaBarra = 5;
let incrementoVelocidade = 1; // Valor pelo qual a velocidade da bola será alterada a cada impacto

function setup() {
  createCanvas(800, 400);
  
  raqueteJogador = createVector(10, height / 2 - 50);
  raqueteComputador = createVector(width - 20, height / 2 - 50);
  
  reiniciarBola();
}

function draw() {
  background(0);
  
  // Desenhar barras horizontais
  fill(255);
  rect(0, 0, width, alturaBarra); // Barra no topo
  rect(0, height - alturaBarra, width, alturaBarra); // Barra na parte inferior
  
  // Desenhar raquetes
  fill(255);
  rect(raqueteJogador.x, raqueteJogador.y, 10, 80);
  rect(raqueteComputador.x, raqueteComputador.y, 10, 80);
  
  // Desenhar bola
  ellipse(bolaX, bolaY, 15, 15);
  
  // Movimento da bola
  bolaX += velocidadeBolaX;
  bolaY += velocidadeBolaY;
  
  // Bola quicando nas barras horizontais
  if (bolaY <= alturaBarra || bolaY >= height - alturaBarra) {
    velocidadeBolaY *= -1;
  }
  
  // Bola tocando na raquete do jogador
  if (bolaX <= raqueteJogador.x + 10 && bolaY >= raqueteJogador.y && bolaY <= raqueteJogador.y + 100) {
    velocidadeBolaX *= -1;
    
    // Aumentar a velocidade da bola após impacto
    aumentarVelocidadeBola();
    
    // Movimento aleatório para a raquete do computador quando o jogador toca na bola
    raqueteComputador.y = random(0, height - 100);
  }
  
  // Bola tocando na raquete do computador
  if (bolaX >= raqueteComputador.x && bolaY >= raqueteComputador.y && bolaY <= raqueteComputador.y + 100) {
    velocidadeBolaX *= -1;
    
    // Aumentar a velocidade da bola após impacto
    aumentarVelocidadeBola();
  }
  
  // Marcação de gol (quando a bola sai dos limites laterais)
  if (bolaX < 0 || bolaX > width) {
    reiniciarBola();
  }
  
  // Movimento da raquete do jogador
  raqueteJogador.y = constrain(mouseY - 50, 0, height - 100);
  
  // Movimento da raquete do computador (se move para cima e para baixo)
  raqueteComputador.y += velocidadeRaqueteComputador;
  
  // Inverter o movimento quando a raquete atingir o topo ou a parte inferior da tela
  if (raqueteComputador.y <= 0 || raqueteComputador.y >= height - 100) {
    velocidadeRaqueteComputador *= -1;
  }
}

function reiniciarBola() {
  bolaX = width / 2;
  bolaY = height / 2;
  velocidadeBolaX = random([-5, 5]);
  velocidadeBolaY = random(-3, 3);
}

function aumentarVelocidadeBola() {
  // Incrementar as velocidades de X e Y com base no incrementoVelocidade
  if (velocidadeBolaX > 0) {
    velocidadeBolaX += incrementoVelocidade;
  } else {
    velocidadeBolaX -= incrementoVelocidade;
  }
  
  if (velocidadeBolaY > 0) {
    velocidadeBolaY += incrementoVelocidade;
  } else {
    velocidadeBolaY -= incrementoVelocidade;
  }
}
