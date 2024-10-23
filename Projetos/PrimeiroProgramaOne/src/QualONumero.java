import java.util.Random;
import java.util.Scanner;

public class QualONumero {
    public static void main(String[] args) {
        Random gerador = new Random();
        Scanner scanner = new Scanner(System.in);

        int numeroSecreto = gerador.nextInt(101);
        int tentativas = 0;

        while (tentativas < 5){
            System.out.println("Encontre o número secreto. Digite de 1 a 100.");
            int chute = scanner.nextInt();
            if (numeroSecreto == chute){
                System.out.println("Parabéns! Você acertou. O número é: " + numeroSecreto);
                break;
            }else if (numeroSecreto > chute){
                System.out.println("Errou! o número é maior.");
            }else {
                System.out.println("Errou! o número é menor.");
            }

            tentativas++;

            if (tentativas == 5){
                System.out.println("Acabou suas tentativas. O numero secreto era: " + numeroSecreto);
            }
        }
    }
}
