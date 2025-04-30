package midia.models;

import java.time.LocalDateTime;

public class PodcastEpisodio extends ArquivoMidia {
    private String nomePodcast;
    private int numeroEpisodio;
    private LocalDateTime dataEpisodio;
    private String descricao;

    public PodcastEpisodio(String id, String titulo, int duracaoSegundos, String caminhoArquivo, String formato, boolean favorito, String nomePodcast, int numeroEpisodio, LocalDateTime dataEpisodio, String descricao) {
        super(id, titulo, duracaoSegundos, caminhoArquivo, formato, favorito);
        this.nomePodcast = nomePodcast;
        this.numeroEpisodio = numeroEpisodio;
        this.dataEpisodio = dataEpisodio;
        this.descricao = descricao;
    }

    public String getNomePodcast() {
        return nomePodcast;
    }

    public void setNomePodcast(String nomePodcast) {
        this.nomePodcast = nomePodcast;
    }

    public int getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(int numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public LocalDateTime getDataEpisodio() {
        return dataEpisodio;
    }

    public void setDataEpisodio(LocalDateTime dataEpisodio) {
        this.dataEpisodio = dataEpisodio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
