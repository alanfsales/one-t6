import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        String nome = "Alan Sales";
        String tipoConta = "Corrente";
        double saldo = 1599.99;
        int opcao = 0;

        System.out.println("**********************************");
        System.out.println("\nNome do cliente: " + nome);
        System.out.println("Tipo Conta: " + tipoConta);
        System.out.println("Saldo atual: " + saldo);
        System.out.println("\n**********************************");

        String menu = """
                
                **Digite sua opção**
                1 - Consultar Saldo
                2 - Transferir
                3 - Depositar
                4 - Sair
                """;

        while (opcao != 4){
            System.out.println(menu);
            opcao = leitura.nextInt();

            if (opcao == 1){
                System.out.println("Saldo atual: " + saldo);
            }else if (opcao == 2){
                System.out.println("Digite o valor que deseja transferir:");
                double  valor = leitura.nextDouble();
                if (valor <= saldo){
                    saldo -= valor;
                    System.out.println("Saldo novo: " + saldo);
                }else {
                    System.out.println("Saldo insuficiente.");
                }
            }else if (opcao == 3){
                System.out.println("Digite o valor que deseja depositar:");
                double  valor = leitura.nextDouble();
                if (valor > 0){
                    saldo += valor;
                    System.out.println("Saldo novo: " + saldo);
                }else {
                    System.out.println("Valor inválido");
                }
            }else if(opcao != 4){
                System.out.println("Opção inválida");
            }
        }
    }
}
