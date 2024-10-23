package princial;

import java.util.Scanner;

public class ExercicioException1 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Numero: ");
        int a = entrada.nextInt();
        System.out.println("dividido por: ");
        int b = entrada.nextInt();

        try {
            double res = a/b;
            System.out.println("Resultado: " + res);
        }catch (ArithmeticException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
