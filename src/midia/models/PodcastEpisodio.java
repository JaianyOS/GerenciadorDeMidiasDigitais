package midia.models;

import java.time.LocalDate;

public class PodcastEpisodio extends ArquivoMidia {
    private String nomePodcast;
    private int numeroEpisodio;
    private LocalDate dataPublicacao;
    private String descricaoResumida;

    public PodcastEpisodio(String id, String titulo, int duracaoSegundos, String caminhoArquivo, String formato, boolean favorito,
                           String nomePodcast, int numeroEpisodio, LocalDate dataPublicacao, String descricaoResumida) {
        super(id, titulo, duracaoSegundos, caminhoArquivo, formato, favorito);
        this.nomePodcast = nomePodcast;
        this.numeroEpisodio = numeroEpisodio;
        this.dataPublicacao = dataPublicacao;
        this.descricaoResumida = descricaoResumida;
    }

    @Override
    public void play() {
        System.out.printf("▶️ Tocando podcast: %s - Episódio %d: %s%n", nomePodcast, numeroEpisodio, getTitulo());
    }

    @Override
    public String getDetalhesExibicao() {
        return String.format("PODCAST | %s - Ep.%d: %s | Data: %s | %s | Favorito: %s",
                nomePodcast, numeroEpisodio, getTitulo(), dataPublicacao, descricaoResumida, isFavorito() ? "Sim" : "Não");
    }

    @Override
    public String toString() {
        return getDetalhesExibicao();
    }
}