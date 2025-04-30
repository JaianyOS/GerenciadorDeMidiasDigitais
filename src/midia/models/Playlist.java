package midia.models;

import java.util.List;

public class Playlist {
    private String id;
    private String nome;
    private String descricao;
    private List<ArquivoMidia> playlist;

    public Playlist(String id, String nome, String descricao, List<ArquivoMidia> playlist) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.playlist = playlist;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<ArquivoMidia> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<ArquivoMidia> playlist) {
        this.playlist = playlist;
    }
}
