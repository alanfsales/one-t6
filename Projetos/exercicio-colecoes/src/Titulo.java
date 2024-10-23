public class Titulo implements Comparable<Titulo> {

    private String nome;

    public Titulo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public int compareTo(Titulo outro) {
        return nome.compareTo(outro.getNome());
    }
}
