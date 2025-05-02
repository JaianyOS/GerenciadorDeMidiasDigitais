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

    // implementaçao dos metodos abstratos herdados da classe mae

    @Override
    public String getDetalhesExibicao() {
        return String.format("MUSICA   | Título: %s | Artista: %s | Álbum: %s (%d) | Duração: %s | Favorito: %s",
                getTitulo(),
                artista,
                album,
                anoLancamento,
                formatarDuracao(getDuracaoSegundos()),
                isFavorito() ? "SIM" : "NÃO");
    }

    @Override
    public void play() {
        System.out.printf("MÚSICA || ▶️ %s | %s (%s)...%n",
                getTitulo(),
                artista,
                formatarDuracao(getDuracaoSegundos())
        );
    }

    // metodo auxiliar privado só pra formatar a duracao direitinho

    private String formatarDuracao(int totalSegundos) {
        if (totalSegundos < 0) return "00:00";

        long horas = totalSegundos / 3600;
        long minutos = (totalSegundos % 3600) / 60;
        long segundos = totalSegundos % 60;

        if (horas > 0)
            return String.format("%02d:%02d:%02d", horas, minutos, segundos);
        else
            return String.format("%02d:%02d", minutos, segundos);
    }
}
