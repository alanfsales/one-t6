package br.com.screenmatch.principal;

import br.com.screenmatch.model.*;
import br.com.screenmatch.repository.SerieRepository;
import br.com.screenmatch.service.ConsumoAPI;
import br.com.screenmatch.service.ConverteDados;

import java.util.*;
import java.util.stream.Collectors;

public class Principal2 {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=fb1f42b3";

    private List<DadosSerie> dadosSeries = new ArrayList<>();

    private SerieRepository repository;

    private List<Serie> series;

    Optional<Serie> serieBusca;

    public Principal2(SerieRepository repository) {
        this.repository = repository;
    }

    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0){
            var menu = """
                
                1 - Buscar Séries
                2 - Buscar Episódios
                3 - Listar Séries
                4 - Buscar Série por Título
                5 - Buscar Série por Ator
                6 - Buscar Top 5 Séries
                7 - Buscar Série por Categoria
                8 - Buscar por Total de temporadas e avalicao
                9 - Buscar Episodio por trecho
                10 - Top 5 Episodio por série
                11 - Buscar um Episodio apartir de uma data
                0 - Sair                                 
                """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarSerieWeb();
                    break;
                case 2:
                    buscarEpisodioPorSerie();
                    break;
                case 3:
                    listarSeriesBuscadas();
                    break;
                case 4:
                    buscarSeriePorTitulo();
                    break;
                case 5:
                    burcarSeriePorAtor();
                    break;
                case 6:
                    buscarTopSeries();
                    break;
                case 7:
                    buscarSeriePorCategoria();
                    break;
                case 8:
                    buscarPorTotalTemporadas();
                    break;
                case 9:
                    buscarEpisodioPorTrecho();
                    break;
                case 10:
                    topEpisodioPorSerie();
                    break;
                case 11:
                    buscarEpisodioApartirDeUmaData();
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void buscarSerieWeb() {
        DadosSerie dados = getDadosSerie();
        Serie serie = new Serie(dados);
//        dadosSeries.add(dados);
        repository.save(serie);
        System.out.println(dados);
    }

    private DadosSerie getDadosSerie() {
        System.out.println("Digite o nome da série para busca");
        var nomeSerie = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        return dados;
    }

    private void buscarEpisodioPorSerie(){
        listarSeriesBuscadas();
        System.out.println("Escolha um série pelo nome: ");
        var nomeSerie = leitura.nextLine();

        Optional<Serie> serie =  repository.findByTituloContainingIgnoreCase(nomeSerie);

        if (serie.isPresent()){
            var serieEcontrada = serie.get();
            List<DadosTemporada> temporadas = new ArrayList<>();

            for (int i = 1; i <= serieEcontrada.getTotalTemporadas(); i++) {
                var json = consumo.obterDados(ENDERECO + serieEcontrada.getTitulo().replace(" ", "+") + "&season=" + i + API_KEY);
                DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
                temporadas.add(dadosTemporada);
            }
            temporadas.forEach(System.out::println);

            List<Episodio> episodios = temporadas.stream()
                    .flatMap(d -> d.episodios().stream()
                            .map(e -> new Episodio(d.numero(),e)))
                    .collect(Collectors.toList());

            serieEcontrada.setEpisodios(episodios);

            repository.save(serieEcontrada);
        }else{
            System.out.println("Série não encontrada");
        }
    }

    private void listarSeriesBuscadas() {
        series = repository.findAll();
        series.stream()
                .sorted(Comparator.comparing(Serie::getGenero))
                .forEach(System.out::println);
    }

    private void buscarSeriePorTitulo() {
        System.out.println("Escolha um série pelo nome: ");
        var nomeSerie = leitura.nextLine();

        serieBusca = repository.findByTituloContainingIgnoreCase(nomeSerie);

        if (serieBusca.isPresent()){
            System.out.println("Dados da Série: " + serieBusca.get());
        }else {
            System.out.println("Série não encontrada");
        }
    }

    private void burcarSeriePorAtor() {
        System.out.println("Digite o nome do ator: ");
        var nomeAtor = leitura.nextLine();

        System.out.println("Avaliação apartir de que valor?");
        var avalicao = leitura.nextDouble();

        List<Serie> seriesBuscadas = repository.findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(nomeAtor, avalicao);

        System.out.println("Séries que " + nomeAtor + " trabalhou: ");
        seriesBuscadas.forEach(s -> System.out.println(s.getTitulo() + " Avaliação: " + s.getAvaliacao()));
    }

    private  void buscarTopSeries(){
        List<Serie> seriesTop = repository.findTop5ByOrderByAvaliacaoDesc();
        System.out.println("Séries Top 5: ");
        seriesTop.forEach(s -> System.out.println(s.getTitulo() + " - Avaliação: " + s.getAvaliacao()));
    }

    private void buscarSeriePorCategoria(){
        System.out.println("Digite a categoria/genero que deseja buscar: ");
        var nomeGenero = leitura.nextLine();
        Categoria categoria = Categoria.fromPortugues(nomeGenero);

        List<Serie> seriesCategoria = repository.findByGenero(categoria);
        System.out.println("Séries por Categoria: ");
        seriesCategoria.forEach(System.out::println);
    }

    private void buscarPorTotalTemporadas(){
        System.out.println("Digite até quantas temporadas: ");
        var totalTemporadas = leitura.nextInt();

        System.out.println("Avaliação apartir de que valor?");
        var avaliacao = leitura.nextDouble();

//        List<Serie> sereistemporadas = repository.findByTotalTemporadasLessThanEqualAndAvaliacaoGreaterThanEqual(totalTemporadas, avalicao);
        List<Serie> sereistemporadas = repository.seriesPorTemporadasEAvaliacao(totalTemporadas, avaliacao);

        System.out.println("Series filtradas: ");
        sereistemporadas.forEach(System.out::println);
    }

    private void buscarEpisodioPorTrecho(){
        System.out.println("Qual nome do episodio para busca: ");
        var trechoEpisodio = leitura.nextLine();

        List<Episodio> episodiosEncontrado = repository.episodioPorTrecho(trechoEpisodio);

        episodiosEncontrado.forEach(e ->
                System.out.printf("Série: %s Temporada %s - Episodio %s - %s\n",
                        e.getSerie().getTitulo(), e.getTemporada(), e.getNumeroEpisodio(), e.getTitulo()));
    }

    private void topEpisodioPorSerie(){
        buscarSeriePorTitulo();
        if (serieBusca.isPresent()){
            Serie serie = serieBusca.get();
            List<Episodio> topEpisodios = repository.topEpisodioPorSerie(serie);
            topEpisodios.forEach(e ->
                    System.out.printf("Série: %s Temporada %s - Episodio %s - %s Avaliação %s\n",
                            e.getSerie().getTitulo(), e.getTemporada(),
                            e.getNumeroEpisodio(), e.getTitulo(), e.getAvaliacao()));
        }
    }

    private void buscarEpisodioApartirDeUmaData() {
        buscarSeriePorTitulo();
        if (serieBusca.isPresent()){
            Serie serie = serieBusca.get();
            System.out.println("Digite o ano limite de lançamento");
            var anoLancamento = leitura.nextInt();
            leitura.nextLine();

            List<Episodio> episodiosAno = repository.episodiosPorSerieEAno(serie, anoLancamento);
            episodiosAno.forEach(System.out::println);
        }
    }
}
