import java.util.*;

public class LIsta {

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> lista = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            lista.add(random.nextInt(100));
        }

        System.out.println("Antes-----------");
        for (Integer i :    lista) {
            System.out.println(i);
        }

        Collections.sort(lista);

        System.out.println("Depois--------------");
        for (Integer i :    lista) {
            System.out.println(i);
        }

        Titulo t1 = new Titulo("Z");
        Titulo t2 = new Titulo("B");
        Titulo t3 = new Titulo("M");

        List<Titulo> titulos = new ArrayList<>();
        titulos.add(t1);
        titulos.add(t2);
        titulos.add(t3);

        System.out.println("Antes-------------");
        for (Titulo titulo : titulos) {
            System.out.println(titulo.getNome());
        }

//        Collections.sort(titulos);
        titulos.sort(Comparator.comparing(Titulo::getNome));

        System.out.println("Depois-------------");
        for (Titulo titulo : titulos) {
            System.out.println(titulo.getNome());
        }
    }
}
