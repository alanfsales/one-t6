package br.com.topmusica.principal;

import br.com.topmusica.modelo.Artista;
import br.com.topmusica.modelo.Musica;
import br.com.topmusica.modelo.Tipo;
import br.com.topmusica.repository.ArtistaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ArtistaRepository repository;

    public Principal(ArtistaRepository repositoryy) {
        this.repository = repositoryy;
    }

    public void menu(){
        var opcao = -1;

        while (opcao != 9){
            var menu = """
                \n*** Top Músicas ***
                
                1 - Cadastrar Artistas
                2 - Cadastrar músicas
                3 - Listar músicas
                4 - Buscar músicas por artistas
                5 - Pesquisar dados sobre um artista
                
                9 - Sair
                """;
            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao){
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicaPorArtista();
                    break;
                case 5:
                    pesqusarDadosSobreArtista();
                    break;
                case 9:
                    System.out.println("Saindo....");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void pesqusarDadosSobreArtista() {
    }

    private void buscarMusicaPorArtista() {
        System.out.println("Digite o nome do artista:");
        var nome = leitura.nextLine();
        List<Musica> musicas = repository.buscarMusicasPorArtista(nome);
        musicas.forEach(System.out::println);
    }

    private void listarMusicas() {
        List<Artista> artistas = repository.findAll();
        artistas.forEach(a -> a.getMusicas().forEach(System.out::println));
    }

    private void cadastrarMusica() {
        System.out.println("Qual artista?");
        var nomeArtista = leitura.nextLine();
        Optional<Artista> artistaBusca = repository.findByNomeContainingIgnoreCase(nomeArtista);

        if (artistaBusca.isPresent()){
            System.out.println("Qual o titulo da musica?");
            var titulo = leitura.nextLine();

            Musica musica = new Musica(titulo, artistaBusca.get());
            artistaBusca.get().getMusicas().add(musica);

            repository.save(artistaBusca.get());
        }else {
            System.out.println("Artista não encontrado");
        }
    }

    private void cadastrarArtista() {
        var cadastrarNovo = "s";

        while (cadastrarNovo.equalsIgnoreCase("s")){
            System.out.println("Informe o nome do artista: ");
            String nome = leitura.nextLine();

            System.out.println("Informe o tipo desse artista: (solo, dupla, banda)");
            String tipo = leitura.nextLine();

            Tipo tipoArtista = Tipo.valueOf(tipo.toUpperCase());

            Artista artista = new Artista(nome, tipoArtista);

            repository.save(artista);

            System.out.println("Cadastrar outro artista? (S/N)");
            cadastrarNovo = leitura.nextLine();
        }
    }

}
