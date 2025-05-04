package midia.ui.submenus;

import midia.interfaces.IBibliotecaService;
import midia.models.ArquivoMidia;
import midia.util.TipoMidia;

import java.util.List;
import java.util.Scanner;

public class ISubmenuBuscarMidia implements ISubmenu {
    private final IBibliotecaService bibliotecaService;
    private final Scanner scanner;

    public ISubmenuBuscarMidia(IBibliotecaService bibliotecaService, Scanner scanner) {
        this.bibliotecaService = bibliotecaService;
        this.scanner = scanner;
    }

    @Override
    public void exibir() {
        System.out.println("\n1. Buscar por título");
        System.out.println("2. Buscar por termo e tipo");
        System.out.print("Escolha a opção de busca: ");
        String opcao = scanner.nextLine();

        switch (opcao) {
            case "1":
                buscarPorTitulo();
                break;
            case "2":
                buscarPorTermoETipo();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private void buscarPorTitulo() {
        System.out.print("Digite parte do título: ");
        String titulo = scanner.nextLine();
        List<ArquivoMidia> resultados = bibliotecaService.buscarMidiaPorTitulo(titulo);
        exibirResultados(resultados);
    }

    private void buscarPorTermoETipo() {
        System.out.print("Digite o termo de busca: ");
        String termo = scanner.nextLine();
        System.out.println("Tipo de mídia: 1-Música  2-Podcast  3-Audiobook");
        String tipoStr = scanner.nextLine();
        TipoMidia tipo;
        switch (tipoStr) {
            case "1": tipo = TipoMidia.MUSICA; break;
            case "2": tipo = TipoMidia.PODCAST; break;
            case "3": tipo = TipoMidia.AUDIOBOOK; break;
            default:
                System.out.println("Tipo inválido!");
                return;
        }
        List<ArquivoMidia> resultados = bibliotecaService.buscarMidia(termo, tipo);
        exibirResultados(resultados);
    }

    private void exibirResultados(List<ArquivoMidia> resultados) {
        if (resultados.isEmpty()) {
            System.out.println("Nenhuma mídia encontrada.");
        } else {
            System.out.println("\nResultados:");
            for (ArquivoMidia m : resultados) {
                System.out.println(m.getDetalhesExibicao());
            }
        }
    }
}