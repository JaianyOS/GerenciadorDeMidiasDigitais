package midia.models;

import midia.interfaces.IFavoritavel;
import midia.interfaces.IReproduzivel;
import midia.util.GeradorID;

import java.io.Serializable;
import java.util.UUID;

public abstract class ArquivoMidia implements IReproduzivel, IFavoritavel,Serializable {
    private String id;
    private String titulo;
    private int duracaoSegundos;
    private String caminhoArquivo;
    private String formato;
    private boolean favorito;

    public ArquivoMidia(String id, String titulo, int duracaoSegundos, String caminhoArquivo, String formato, boolean favorito) {
        this.id = GeradorID.novoID();
        this.titulo = titulo;
        this.duracaoSegundos = duracaoSegundos;
        this.caminhoArquivo = caminhoArquivo;
        this.formato = formato;
        this.favorito = favorito;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public void setDuracaoSegundos(int duracaoSegundos) {
        this.duracaoSegundos = duracaoSegundos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // implementação da interface IFavoritavel

    @Override
    public boolean isFavorito() {
        return favorito;
    }

    @Override
    public void marcarFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    // métodos abstratos

    // implementação da interface IReproduzivel
    @Override
    public abstract void play();

    public abstract String getDetalhesExibicao();
}
