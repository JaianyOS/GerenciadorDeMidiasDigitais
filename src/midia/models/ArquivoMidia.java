package midia.models;

import java.util.UUID;

public abstract class ArquivoMidia {
    private String id;
    private String titulo;
    private int duracaoSegundos;
    private String caminhoArquivo;
    private String formato;
    private boolean favorito;

    public ArquivoMidia(String id, String titulo, int duracaoSegundos, String caminhoArquivo, String formato, boolean favorito) {
        this.id = UUID.randomUUID().toString();
        this.titulo = titulo;
        this.duracaoSegundos = duracaoSegundos;
        this.caminhoArquivo = caminhoArquivo;
        this.formato = formato;
        this.favorito = favorito;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }
}
