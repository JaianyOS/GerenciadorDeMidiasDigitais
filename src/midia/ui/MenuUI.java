package midia.ui;

import midia.interfaces.IBibliotecaService;
import midia.excecoes.EntradaInvalidaException;
import java.util.InputMismatchException;
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

    // Métodos auxiliares (apenas esqueleto, implemente conforme sua lógica)
    private void submenuAdicionarMidia() {
        System.out.println("TODO: Implementar submenu de adicionar mídia.");
    }

    private void submenuListarMidias() {
        System.out.println("TODO: Implementar submenu de listar mídias.");
    }

    private void submenuBuscarMidia() {
        System.out.println("TODO: Implementar submenu de buscar mídia.");
    }

    private void submenuGerenciarPlaylists() {
        System.out.println("TODO: Implementar submenu de gerenciar playlists.");
    }

    private void submenuFavoritos() {
        System.out.println("TODO: Implementar marcar/desmarcar favorito.");
    }

    private void listarFavoritos() {
        System.out.println("TODO: Implementar listagem de favoritos.");
    }
}