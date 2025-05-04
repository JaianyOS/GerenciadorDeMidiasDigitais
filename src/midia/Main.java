//Marcus Arthur Carvalho Luz - 12211BSI284
//Jaiany Oliveira Silva - 12221BSI226
//Samira Rodrigues Silva - 12311BSI203
//Eduardo teodoro ferreira - 12011BSI286
//Giovanna Vida Krempel - 12221BSI234
package midia;

import midia.interfaces.IBibliotecaService;
import midia.interfaces.IPersistenciaService;
import midia.models.Biblioteca;
import midia.services.*;
import midia.ui.MenuUI;
import midia.excecoes.PersistenciaException;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        final String CAMINHO_ARQUIVO = "midia.dat";
        IPersistenciaService persistenciaService = new PersistenciaService();
        Biblioteca biblioteca;
        try {
            biblioteca = persistenciaService.carregar(CAMINHO_ARQUIVO);
        } catch (PersistenciaException e) {
            biblioteca = new Biblioteca(new HashMap<>(), new HashMap<>());
        }
        IBibliotecaService bibliotecaService = new BibliotecaService(biblioteca, persistenciaService, CAMINHO_ARQUIVO);
        MenuUI menuUI = new MenuUI(bibliotecaService);
        menuUI.exibirMenuPrincipal();
    }
}