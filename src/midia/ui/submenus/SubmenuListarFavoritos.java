package midia.ui.submenus;

import midia.interfaces.IBibliotecaService;
import java.util.Scanner;

public class SubmenuListarFavoritos implements Submenu {
    private final IBibliotecaService bibliotecaService;

    public SubmenuListarFavoritos(IBibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    @Override
    public void exibir() {
        var favoritos = bibliotecaService.listarFavoritos();
        if (favoritos.isEmpty()) {
            System.out.println("Nenhuma mídia favorita.");
        } else {
            favoritos.forEach(m -> System.out.println(m.getDetalhesExibicao()));
        }
    }
}