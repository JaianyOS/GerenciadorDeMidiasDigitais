package midia.models;

import java.util.HashMap;
import java.util.Map;

public class Biblioteca {
    private Map<String, ArquivoMidia> todasAsMidias;
    private Map<String, Playlist> todasAsPlaylists;

    public Biblioteca() {
        this.todasAsMidias = new HashMap<>();
        this.todasAsPlaylists = new HashMap<>();
    }

    public Biblioteca(Map<String, ArquivoMidia> todasAsMidias, Map<String, Playlist> todasAsPlaylists) {
        this.todasAsMidias = todasAsMidias;
        this.todasAsPlaylists = todasAsPlaylists;
    }

    public Map<String, ArquivoMidia> getTodasAsMidias() {
        return todasAsMidias;
    }

    public void setTodasAsMidias(Map<String, ArquivoMidia> todasAsMidias) {
        this.todasAsMidias = todasAsMidias;
    }

    public Map<String, Playlist> getTodasAsPlaylists() {
        return todasAsPlaylists;
    }

    public void setTodasAsPlaylists(Map<String, Playlist> todasAsPlaylists) {
        this.todasAsPlaylists = todasAsPlaylists;
    }

    public void adicionarMidia(ArquivoMidia midia) {
        this.todasAsMidias.put(midia.getId(), midia);
    }

    public void adicionarPlaylist(Playlist playlist) {
        this.todasAsPlaylists.put(playlist.getId(), playlist);
    }
}
