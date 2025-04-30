package midia.models;

public class AudiobookCapitulo extends ArquivoMidia {
    private String nomeLivro;
    private String nomeAutor;
    private int numeroCapitulo;

    public AudiobookCapitulo(String id, String titulo, int duracaoSegundos, String caminhoArquivo, String formato, boolean favorito, String nomeLivro, String nomeAutor, int numeroCapitulo) {
        super(id, titulo, duracaoSegundos, caminhoArquivo, formato, favorito);
        this.nomeLivro = nomeLivro;
        this.nomeAutor = nomeAutor;
        this.numeroCapitulo = numeroCapitulo;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public int getNumeroCapitulo() {
        return numeroCapitulo;
    }

    public void setNumeroCapitulo(int numeroCapitulo) {
        this.numeroCapitulo = numeroCapitulo;
    }
}
