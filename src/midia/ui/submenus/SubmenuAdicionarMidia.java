package midia.ui.submenus;

import midia.interfaces.IBibliotecaService;
import midia.models.Musica;
import midia.models.PodcastEpisodio;
import midia.models.AudiobookCapitulo;

import java.time.LocalDate;
import java.util.Scanner;

public class SubmenuAdicionarMidia implements Submenu {
    private final IBibliotecaService bibliotecaService;
    private final Scanner scanner;

    public SubmenuAdicionarMidia(IBibliotecaService bibliotecaService, Scanner scanner) {
        this.bibliotecaService = bibliotecaService;
        this.scanner = scanner;
    }

    @Override
    public void exibir() {
        System.out.println("\n1. Música\n2. Podcast\n3. Audiobook\nEscolha o tipo de mídia para adicionar:");
        String opcao = scanner.nextLine();
        try {
            switch (opcao) {
                case "1":
                    adicionarMusica();
                    break;
                case "2":
                    adicionarPodcast();
                    break;
                case "3":
                    adicionarAudiobook();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } catch (Exception e) {
            System.out.println("Erro ao adicionar mídia: " + e.getMessage());
        }
    }

    private void adicionarMusica() throws Exception {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Duração (segundos): ");
        int duracao = Integer.parseInt(scanner.nextLine());
        System.out.print("Caminho do arquivo: ");
        String caminho = scanner.nextLine();
        System.out.print("Formato: ");
        String formato = scanner.nextLine();
        System.out.print("Artista: ");
        String artista = scanner.nextLine();
        System.out.print("Álbum: ");
        String album = scanner.nextLine();
        System.out.print("Gênero: ");
        String genero = scanner.nextLine();
        System.out.print("Ano de lançamento: ");
        int ano = Integer.parseInt(scanner.nextLine());

        Musica m = new Musica(null, titulo, duracao, caminho, formato, false, artista, album, genero, ano);
        bibliotecaService.adicionarMusica(m);
        System.out.println("Música adicionada com sucesso!");
    }

    private void adicionarPodcast() throws Exception {
        System.out.print("Título do episódio: ");
        String titulo = scanner.nextLine();
        System.out.print("Duração (segundos): ");
        int duracao = Integer.parseInt(scanner.nextLine());
        System.out.print("Caminho do arquivo: ");
        String caminho = scanner.nextLine();
        System.out.print("Formato: ");
        String formato = scanner.nextLine();
        System.out.print("Nome do podcast: ");
        String nomePodcast = scanner.nextLine();
        System.out.print("Número do episódio: ");
        int numeroEpisodio = Integer.parseInt(scanner.nextLine());
        System.out.print("Data de publicação (AAAA-MM-DD): ");
        String dataStr = scanner.nextLine();
        LocalDate dataPublicacao = LocalDate.parse(dataStr);
        System.out.print("Descrição resumida: ");
        String descricaoResumida = scanner.nextLine();

        PodcastEpisodio p = new PodcastEpisodio(
                null, titulo, duracao, caminho, formato, false,
                nomePodcast, numeroEpisodio, dataPublicacao, descricaoResumida
        );
        bibliotecaService.adicionarPodcast(p);
        System.out.println("Podcast adicionado com sucesso!");
    }

    private void adicionarAudiobook() throws Exception {
        System.out.print("Título do capítulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Duração (segundos): ");
        int duracao = Integer.parseInt(scanner.nextLine());
        System.out.print("Caminho do arquivo: ");
        String caminho = scanner.nextLine();
        System.out.print("Formato: ");
        String formato = scanner.nextLine();
        System.out.print("Nome do livro: ");
        String nomeLivro = scanner.nextLine();
        System.out.print("Nome do autor: ");
        String nomeAutor = scanner.nextLine();
        System.out.print("Número do capítulo: ");
        int numeroCapitulo = Integer.parseInt(scanner.nextLine());

        AudiobookCapitulo a = new AudiobookCapitulo(
                null, titulo, duracao, caminho, formato, false,
                nomeLivro, nomeAutor, numeroCapitulo
        );
        bibliotecaService.adicionarAudiobook(a);
        System.out.println("Audiobook adicionado com sucesso!");
    }
}