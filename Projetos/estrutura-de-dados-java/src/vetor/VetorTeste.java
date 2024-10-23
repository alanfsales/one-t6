package vetor;

public class VetorTeste {

    public static void main(String[] args) {
//        vetor.Aluno a1 = new vetor.Aluno("Joao");
//        vetor.Aluno a2 = new vetor.Aluno("Jose");
//
        Vetor lista = new Vetor();
//
//        System.out.println(lista.tamanho());
//        lista.adiciona(a1);
//        System.out.println(lista.tamanho());
//        lista.adiciona(a2);
//        System.out.println(lista.tamanho());
//
//        System.out.println(lista);
//        System.out.println(lista.contem(a1));
//        vetor.Aluno a3 = new vetor.Aluno("Danilo");
//        System.out.println(lista.contem(a3));
//
//        vetor.Aluno x = lista.pega(1);
//        System.out.println(x);
//
//        lista.adiciona(1, a3);
//        System.out.println(lista);
//
//        lista.remove(1);
//        System.out.println(lista);

        for(int i = 0; i < 300; i++) {
            Aluno y = new Aluno("Joao" + i);
            lista.adiciona(y);
        }
        System.out.println(lista);

    }
}