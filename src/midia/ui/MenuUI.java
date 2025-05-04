package midia.ui;

import midia.interfaces.IBibliotecaService;
import midia.models.*;
import midia.util.TipoMidia;
import java.time.LocalDate;
import java.util.Scanner;

public class MenuUI {
    private final IBibliotecaService bibliotecaService;
    private final Scanner scanner;

    public MenuUI(IBibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenuPrincipal() {
        int opcao = -1;
        do {
            System.out.println("\n=== Gerenciador de Mídia Digital ===");
            System.out.println("1. Adicionar Mídia");
            System.out.println("2. Listar Mídias");
            System.out.println("3. Buscar Mídia");
            System.out.println("4. Gerenciar Playlists");
            System.out.println("5. Marcar/Desmarcar Favorito");
            System.out.println("6. Listar Favoritos");
            System.out.println("7. Salvar e Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1:
                        submenuAdicionarMidia();
                        break;
                    case 2:
                        submenuListarMidias();
                        break;
                    case 3:
                        submenuBuscarMidia();
                        break;
                    case 4:
                        submenuGerenciarPlaylists();
                        break;
                    case 5:
                        submenuFavoritos();
                        break;
                    case 6:
                        listarFavoritos();
                        break;
                    case 7:
                        bibliotecaService.salvarBiblioteca();
                        System.out.println("Biblioteca salva. Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número.");
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (opcao != 7);
    }

    // 1. Adicionar Mídia
    private void submenuAdicionarMidia() {
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

    // 2. Listar Mídias
    private void submenuListarMidias() {
        System.out.println("\n1. Todas\n2. Músicas\n3. Podcasts\n4. Audiobooks\nEscolha uma opção:");
        String opcao = scanner.nextLine();
        switch (opcao) {
            case "1":
                bibliotecaService.listarTodasMidias().forEach(m -> System.out.println(m.getDetalhesExibicao()));
                break;
            case "2":
                bibliotecaService.listarMusicas().forEach(m -> System.out.println(m.getDetalhesExibicao()));
                break;
            case "3":
                bibliotecaService.listarPodcasts().forEach(m -> System.out.println(m.getDetalhesExibicao()));
                break;
            case "4":
                bibliotecaService.listarAudiobooks().forEach(m -> System.out.println(m.getDetalhesExibicao()));
                break;
            default:
                System.out.println("Opção inválida!");
        }
        System.out.println("Pressione ENTER para voltar ao menu...");
        scanner.nextLine();
    }

    // 3. Buscar Mídia
    private void submenuBuscarMidia() {
        System.out.print("Digite o título ou parte dele para buscar: ");
        String termo = scanner.nextLine();
        var resultados = bibliotecaService.buscarMidiaPorTitulo(termo);
        if (resultados.isEmpty()) {
            System.out.println("Nenhuma mídia encontrada.");
        } else {
            resultados.forEach(m -> System.out.println(m.getDetalhesExibicao()));
        }
        System.out.println("Pressione ENTER para voltar ao menu...");
        scanner.nextLine();
    }

    // 4. Gerenciar Playlists
    private void submenuGerenciarPlaylists() {
        System.out.println("\n1. Criar Playlist\n2. Adicionar Mídia à Playlist\n3. Remover Mídia da Playlist\n4. Listar Playlists\nEscolha uma opção:");
        String opcao = scanner.nextLine();
        try {
            switch (opcao) {
                case "1":
                    System.out.print("Nome da playlist: ");
                    String nome = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String desc = scanner.nextLine();
                    bibliotecaService.criarPlaylist(nome, desc);
                    System.out.println("Playlist criada!");
                    break;
                case "2":
                    System.out.print("ID da playlist: ");
                    String idPlaylist = scanner.nextLine();
                    System.out.print("ID da mídia: ");
                    String idMidia = scanner.nextLine();
                    bibliotecaService.adicionarMidiaPlaylist(idPlaylist, idMidia);
                    System.out.println("Mídia adicionada à playlist!");
                    break;
                case "3":
                    System.out.print("ID da playlist: ");
                    idPlaylist = scanner.nextLine();
                    System.out.print("ID da mídia: ");
                    idMidia = scanner.nextLine();
                    bibliotecaService.removerMidiaPlaylist(idPlaylist, idMidia);
                    System.out.println("Mídia removida da playlist!");
                    break;
                case "4":
                    bibliotecaService.listarPlaylists().forEach(p -> {
                        System.out.println("ID: " + p.getId() + " | Nome: " + p.getNome() + " | " + p.getDescricao());
                        if (p.getMidias().isEmpty()) {
                            System.out.println("  (vazia)");
                        } else {
                            p.getMidias().forEach(m -> System.out.println("   - " + m.getDetalhesExibicao()));
                        }
                    });
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        System.out.println("Pressione ENTER para voltar ao menu...");
        scanner.nextLine();
    }

    // 5. Marcar/Desmarcar Favorito
    private void submenuFavoritos() {
        System.out.print("ID da mídia: ");
        String id = scanner.nextLine();
        System.out.print("Marcar como favorito? (s/n): ");
        String resp = scanner.nextLine();
        boolean status = resp.equalsIgnoreCase("s");
        try {
            bibliotecaService.marcarMidiaComoFavorita(id, status);
            System.out.println("Status de favorito atualizado!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        System.out.println("Pressione ENTER para voltar ao menu...");
        scanner.nextLine();
    }

    // 6. Listar Favoritos
    private void listarFavoritos() {
        var favoritos = bibliotecaService.listarFavoritos();
        if (favoritos.isEmpty()) {
            System.out.println("Nenhuma mídia favorita.");
        } else {
            favoritos.forEach(m -> System.out.println(m.getDetalhesExibicao()));
        }
        System.out.println("Pressione ENTER para voltar ao menu...");
        scanner.nextLine();
    }
}