import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class principal {
    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        String busca = "";

        while (!busca.equalsIgnoreCase("sair")){
            System.out.println("Digite o CEP: ");
            busca = entrada.nextLine();

            if (busca.equalsIgnoreCase("sair")){
                break;
            }

            try {
                ConsultaCep consultaCep = new ConsultaCep();
                GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();

                Endereco endereco = consultaCep.buscaCep(busca);

                geradorDeArquivo.salvaJson(endereco);

            }catch (RuntimeException | IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
