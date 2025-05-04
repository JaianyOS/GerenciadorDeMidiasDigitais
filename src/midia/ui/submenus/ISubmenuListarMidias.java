package midia.ui.submenus;

import midia.interfaces.IBibliotecaService;
import java.util.Scanner;

public class ISubmenuListarMidias implements ISubmenu {
    private final IBibliotecaService bibliotecaService;
    private final Scanner scanner;

    public ISubmenuListarMidias(IBibliotecaService bibliotecaService, Scanner scanner) {
        this.bibliotecaService = bibliotecaService;
        this.scanner = scanner;
    }

    @Override
    public void exibir() {
        System.out.println("=== Listagem de Mídias ===");
        var midias = bibliotecaService.listarTodasMidias();
        if (midias == null || midias.isEmpty()) {
            System.out.println("Nenhuma mídia cadastrada.");
        } else {
            midias.forEach(midia -> System.out.println(midia.getDetalhesExibicao()));
        }
        System.out.println("Pressione ENTER para voltar ao menu...");
        scanner.nextLine();
    }
}