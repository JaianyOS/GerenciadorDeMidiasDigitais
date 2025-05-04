package midia.services;

import midia.models.Biblioteca;
import midia.interfaces.IPersistenciaService;
import midia.excecoes.PersistenciaException;
import java.io.*;

public class PersistenciaService implements IPersistenciaService {
    @Override
    public void salvar(Biblioteca b, String path) throws PersistenciaException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(b);
        } catch (IOException e) {
            throw new PersistenciaException("Erro ao salvar biblioteca", e);
        }
    }

    @Override
    public Biblioteca carregar(String path) throws PersistenciaException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return (Biblioteca) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new PersistenciaException("Erro ao carregar biblioteca", e);
        }
    }
}