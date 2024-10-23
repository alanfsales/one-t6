package br.com.screenmatch.model;

public class Serie  extends Titulo{

    private int temporada;
    private boolean ativa;
    private int epsodioPorTemporada;
    private int minutosPorEpisodio;

    public Serie(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public int getEpsodioPorTemporada() {
        return epsodioPorTemporada;
    }

    public void setEpsodioPorTemporada(int epsodioPorTemporada) {
        this.epsodioPorTemporada = epsodioPorTemporada;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    @Override
    public int getDuracaoEmMinutos() {
        return temporada * epsodioPorTemporada * minutosPorEpisodio;
    }

    @Override
    public String toString() {
        return "Série: " + this.getNome() + " ("+ this.getAnoDeLancamento()+ ")";
    }
}
