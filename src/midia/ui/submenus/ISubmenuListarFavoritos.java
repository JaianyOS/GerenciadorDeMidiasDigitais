package midia.ui.submenus;

import midia.interfaces.IBibliotecaService;

public class ISubmenuListarFavoritos implements ISubmenu {
    private final IBibliotecaService bibliotecaService;

    public ISubmenuListarFavoritos(IBibliotecaService bibliotecaService) {
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