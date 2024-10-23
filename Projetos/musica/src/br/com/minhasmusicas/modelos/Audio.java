package br.com.minhasmusicas.modelos;

public class Audio {

    private String titulo;
    private int totalReproducoes;
    private int toralCurtidas;
    private int classificacao;

    public void curte(){
        this.toralCurtidas++;
    }

    public void reproduzir(){
        this.totalReproducoes++;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTotalReproducoes() {
        return totalReproducoes;
    }

    public int getToralCurtidas() {
        return toralCurtidas;
    }

    public int getClassificacao() {
        return classificacao;
    }
}