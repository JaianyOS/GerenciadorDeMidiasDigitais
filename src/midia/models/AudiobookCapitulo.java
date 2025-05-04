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

    // implementacao metodos abstratos

    @Override
    public String getDetalhesExibicao() {
        return String.format("AUDIOBOOK || 📗 Livro: %s (%s) | Cap. %d: %s | Duração: %s | Favorito: %s",
                nomeLivro,
                nomeAutor,
                numeroCapitulo,
                getTitulo(),
                formatarDuracao(getDuracaoSegundos()),
                isFavorito() ? "Sim" : "Não");
    }

    @Override
    public void play() {
        System.out.printf("▶️ Tocando Audiobook: '%s' por %s - Cap. %d: '%s' (%s)...%n",
                nomeLivro,
                nomeAutor,
                numeroCapitulo,
                getTitulo(),
                formatarDuracao(getDuracaoSegundos())
        );
    }

    // metodo privado p auxiliar na formatacao da dduracao de segundos

    private String formatarDuracao(int totalSegundos) {
        if (totalSegundos < 0)
            return "00:00";

        long horas = totalSegundos / 3600;
        long minutos = (totalSegundos % 3600) / 60;
        long segundos = totalSegundos % 60;

        if (horas > 0)
            return String.format("%02d:%02d:%02d", horas, minutos, segundos);
        else
            return String.format("%02d:%02d", minutos, segundos);
    }
}
