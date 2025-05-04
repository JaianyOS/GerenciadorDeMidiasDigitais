package midia.ui.submenus;

import midia.interfaces.IBibliotecaService;
import java.util.Scanner;

public class ISubmenuFavoritos implements ISubmenu {
    private final IBibliotecaService bibliotecaService;
    private final Scanner scanner;

    public ISubmenuFavoritos(IBibliotecaService bibliotecaService, Scanner scanner) {
        this.bibliotecaService = bibliotecaService;
        this.scanner = scanner;
    }
//adicionar uma midia como favorito.
    @Override
    public void exibir() {
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
    }
}