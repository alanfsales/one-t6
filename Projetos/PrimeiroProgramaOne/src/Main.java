public class Main {
    public static void main(String[] args) {
        String nome = "Alan";
        String sobrenome = "Sales";
        int idade = 39;
        double salario = 55.5555555;

        System.out.printf("Meu nome é %s %s e tenho %d e ganho %.2f %n", nome, sobrenome, idade, salario);

        String mensagem = """
                Ola Men nome é  %s %s
                Tenho %d anos
                E ganho %.2f
                """.formatted(nome, sobrenome, idade, salario);

        System.out.println(mensagem);
    }
}