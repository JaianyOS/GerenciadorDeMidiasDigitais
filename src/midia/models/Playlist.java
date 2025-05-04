package midia.models;

import midia.util.GeradorID;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Playlist implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String nome;
    private String descricao;
    private List<ArquivoMidia> midias;

    public Playlist(String nome, String descricao) {
        this.id = GeradorID.novoID();
        this.nome = nome;
        this.descricao = descricao;
        this.midias = new ArrayList<>();
    }

    public Playlist(String id, String nome, String descricao, List<ArquivoMidia> midias) {
        this.id = GeradorID.novoID();
        this.nome = nome;
        this.descricao = descricao;
        this.midias = midias;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<ArquivoMidia> getMidias() {
        return midias;
    }

    public void adicionarMidia(ArquivoMidia midia) {
        midias.add(midia);
    }

    public void removerMidia(ArquivoMidia midia) {
        midias.remove(midia);
    }
}