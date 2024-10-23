import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o limete do cartão:");
        double limite = entrada.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        int opcao = 1;
        while (opcao != 0){
            System.out.println("Digite a destrição da compra:");
            String descricao = entrada.next();
            System.out.println("Digite o valor da compra:");
            double valor = entrada.nextDouble();

            Compra compra = new Compra(descricao, valor);

            if(cartao.lancaCompra(compra)){
                System.out.println("Compra realizada!");
                System.out.println("Digite 0 para sair ou 1 para continuar");
                opcao = entrada.nextInt();
            }else {
                System.out.println("Saldo insuficiente!");
                opcao = 0;
            }
        }

        System.out.println("******************************");
        System.out.println("Compras Realizadas\n");

        Collections.sort(cartao.getCompras());
        for (Compra compra: cartao.getCompras()) {
            System.out.println(compra.getDescricao() + " - " + compra.getValor());
        }

        System.out.println("\n******************************");

        System.out.println("\nSaldo do cartão: " +  cartao.getSaldo());
    }
}
