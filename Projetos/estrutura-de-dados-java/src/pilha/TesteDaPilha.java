package pilha;

public class TesteDaPilha {

    public static void main(String[] args) {
        Pilha pilha = new Pilha();

        pilha.insere("Mauricio");
        System.out.println(pilha);

        pilha.insere("Guilherme");
        System.out.println(pilha);

        System.out.println(pilha.vazia());

        String r1 = pilha.remove();
        System.out.println(r1);

        String r2 = pilha.remove();
        System.out.println(r2);

        System.out.println(pilha);

        System.out.println(pilha.vazia());
    }
}