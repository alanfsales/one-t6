package br.com.minhasmusicas.modelos;

public class MinhasPreferidas {

    public void inclui(Audio audio){
        if (audio.getClassificacao() >= 9){
            System.out.println(audio.getTitulo() + " é sucesso");
        }else {
            System.out.println(audio.getTitulo() + " é bom");
        }
    }
}
