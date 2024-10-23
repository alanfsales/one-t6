package princial;

import exception.SenhaInvalidaException;

import java.util.Scanner;

public class ExercicioException2 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Difite a senha: ");
        String senha = entrada.nextLine();

        try {
            validarSenha(senha);
            System.out.println("Senha salva");
        }catch (SenhaInvalidaException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void validarSenha(String senha) {
        if (senha.length() < 4){
            throw new SenhaInvalidaException("Senha inválida!");
        }
    }
}
