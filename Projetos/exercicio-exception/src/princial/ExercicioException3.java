package princial;

import exception.ErroConsultaGitHubException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ExercicioException3 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Difite um usuario GirHub: ");
        String nome = entrada.nextLine();

        String endereco = "https://api.github.com/users/" + nome;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 404){
                throw new ErroConsultaGitHubException("Usuario não encotrado");
            }

            String json = response.body();

            System.out.println(json);

        } catch (IOException | InterruptedException e) {
            System.out.println("Ocooreu um erro");
        } catch (ErroConsultaGitHubException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
