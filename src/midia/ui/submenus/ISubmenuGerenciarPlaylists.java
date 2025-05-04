package midia.ui.submenus;

import midia.interfaces.IBibliotecaService;
import java.util.Scanner;

public class ISubmenuGerenciarPlaylists implements ISubmenu {
    private final IBibliotecaService bibliotecaService;
    private final Scanner scanner;

    public ISubmenuGerenciarPlaylists(IBibliotecaService bibliotecaService, Scanner scanner) {
        this.bibliotecaService = bibliotecaService;
        this.scanner = scanner;
    }

    @Override
    public void exibir() {
        int opcao;
        do {
            System.out.println("\n=== Gerenciar Playlists ===");
            System.out.println("1. Criar Playlist");
            System.out.println("2. Adicionar Mídia à Playlist");
            System.out.println("3. Remover Mídia da Playlist");
            System.out.println("4. Listar Playlists");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    criarPlaylist();
                    break;
                case 2:
                    adicionarMidiaPlaylist();
                    break;
                case 3:
                    removerMidiaPlaylist();
                    break;
                case 4:
                    listarPlaylists();
                    break;
                case 5:
                    System.out.println("Voltando ao menu anterior...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }

    private void criarPlaylist() {
        System.out.print("Nome da playlist: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        try {
            bibliotecaService.criarPlaylist(nome, descricao);
            System.out.println("Playlist criada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao criar playlist: " + e.getMessage());
        }
    }

    private void adicionarMidiaPlaylist() {
        System.out.print("ID da playlist: ");
        String idPlaylist = scanner.nextLine();
        System.out.print("ID da mídia: ");
        String idMidia = scanner.nextLine();
        try {
            bibliotecaService.adicionarMidiaPlaylist(idPlaylist, idMidia);
            System.out.println("Mídia adicionada à playlist!");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar mídia: " + e.getMessage());
        }
    }

    private void removerMidiaPlaylist() {
        System.out.print("ID da playlist: ");
        String idPlaylist = scanner.nextLine();
        System.out.print("ID da mídia: ");
        String idMidia = scanner.nextLine();
        try {
            bibliotecaService.removerMidiaPlaylist(idPlaylist, idMidia);
            System.out.println("Mídia removida da playlist!");
        } catch (Exception e) {
            System.out.println("Erro ao remover mídia: " + e.getMessage());
        }
    }

    private void listarPlaylists() {
        var playlists = bibliotecaService.listarPlaylists();
        if (playlists.isEmpty()) {
            System.out.println("Nenhuma playlist cadastrada.");
        } else {
            playlists.forEach(p -> {
                System.out.println("ID: " + p.getId() + " | Nome: " + p.getNome() + " | Descrição: " + p.getDescricao());
                if (!p.getMidias().isEmpty()) {
                    System.out.println("  Mídias:");
                    p.getMidias().forEach(m -> System.out.println("    - " + m.getDetalhesExibicao()));
                }
            });
        }
    }
}