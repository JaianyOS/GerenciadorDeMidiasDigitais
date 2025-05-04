package midia.interfaces;
import midia.models.Biblioteca;
import midia.excecoes.PersistenciaException;

public interface IPersistenciaService {
    void salvar(Biblioteca biblioteca, String caminhoArquivo) throws PersistenciaException;
    Biblioteca carregar(String caminhoArquivo) throws PersistenciaException;
}