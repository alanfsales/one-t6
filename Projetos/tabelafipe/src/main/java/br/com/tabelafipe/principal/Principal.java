package br.com.tabelafipe.principal;

import br.com.tabelafipe.modelo.Dados;
import br.com.tabelafipe.modelo.Modelos;
import br.com.tabelafipe.modelo.Veiculo;
import br.com.tabelafipe.service.ConsultaApi;
import br.com.tabelafipe.service.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    private Scanner entrada = new Scanner(System.in);
    private ConsultaApi consultaApi = new ConsultaApi();
    private ConverteDados converteDados = new ConverteDados();

    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu() {

        String menu = """
                                
                *** Opções ***
                Carros
                Motos
                Caminhões
                                
                Digite uma das opções para consultar os valores:
                """;

        System.out.println(menu);
        String opcao = entrada.nextLine();
        String endereco = "";

        if ((opcao.toLowerCase().contains("carr"))) {
            endereco = URL_BASE + "carros/marcas";
        } else if ((opcao.toLowerCase().contains("mot"))) {
            endereco = URL_BASE + "motos/marcas";
        } else {
            endereco = URL_BASE + "caminhoes/marcas";
        }

        String json = consultaApi.consulta(endereco);

        List<Dados> marcas = converteDados.obterLista(json, Dados.class);
        marcas.stream().sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("\nInforme o código da marca para consulta: ");
        String codigoMarca = entrada.nextLine();

        endereco = endereco + "/" + codigoMarca + "/modelos";
        json = consultaApi.consulta(endereco);

        Modelos modelosLista = converteDados.obterDados(json, Modelos.class);

        System.out.println("\nModelos dessa marca: ");

        modelosLista.modelos().stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("\nDigite um trecho do nome carro a ser buscado: ");
        String nomeVeiculo = entrada.nextLine();

        List<Dados> modelosFiltrados = modelosLista.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(nomeVeiculo.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println("\nModelos Filtrados");
        modelosFiltrados.forEach(System.out::println);

        System.out.println("\nDigite o código do modelo para buscar os valores:");
        String codigoModelo = entrada.nextLine();

        endereco = endereco + "/" + codigoModelo + "/anos";

        json = consultaApi.consulta(endereco);

        List<Dados> anos = converteDados.obterLista(json, Dados.class);

        List<Veiculo> veiculos = new ArrayList<>();

        for (int i = 0; i < anos.size(); i++) {
            String enderecoAno = endereco + "/" + anos.get(i).codigo();
            json = consultaApi.consulta(enderecoAno);
            Veiculo veiculo = converteDados.obterDados(json, Veiculo.class);
            veiculos.add(veiculo);
        }

        System.out.println("\nTodos os veiculos filtrados com a avaliação");
        veiculos.forEach(System.out::println);

    }
}
