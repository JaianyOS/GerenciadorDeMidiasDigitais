package midia.models;

public class Musica extends ArquivoMidia {
    private String artista;
    private String album;
    private String genero;
    private int anoLancamento;

    public Musica(String id, String titulo, int duracaoSegundos, String caminhoArquivo, String formato, boolean favorito, String artista, String album, String genero, int anoLancamento) {
        super(id, titulo, duracaoSegundos, caminhoArquivo, formato, favorito);
        this.artista = artista;
        this.album = album;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
}
