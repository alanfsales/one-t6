package br.com.screenmatch.calculos;

public class FiltroRecomendacao {

    public void filtrar(Classificavel classificavel){
        if (classificavel.getClassificacao() >= 4){
            System.out.println("Entre os preferidos");
        } else if (classificavel.getClassificacao() >= 2) {
            System.out.println("Bem avaliado");
        }else {
            System.out.println("Assita depois");
        }
    }
}
