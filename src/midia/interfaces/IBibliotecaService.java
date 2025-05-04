package midia.interfaces;

import midia.models.*;
import midia.excecoes.*;
import midia.util.TipoMidia;
import java.util.List;

public interface IBibliotecaService {

    // métodos pra adicionar mídias
    void adicionarMusica(Musica m) throws MidiaDuplicadaException, PersistenciaException;
    void adicionarPodcast(PodcastEpisodio p) throws MidiaDuplicadaException, PersistenciaException;
    void adicionarAudiobook(AudiobookCapitulo a) throws MidiaDuplicadaException, PersistenciaException;

    // métodos p buscar mídias
    ArquivoMidia buscarMidia(String id) throws MidiaNaoEncontradaException;
    List<ArquivoMidia> buscarMidiaPorTitulo(String titulo);
    List<ArquivoMidia> buscarMidia(String termoBusca, TipoMidia tipo);

    // Listar mídias
    List<ArquivoMidia> listarTodasMidias();
    List<Musica> listarMusicas();
    List<PodcastEpisodio> listarPodcasts();
    List<AudiobookCapitulo> listarAudiobooks();

    // Playlists
    void criarPlaylist(String nome, String descricao) throws MidiaDuplicadaException, PersistenciaException;
    void adicionarMidiaPlaylist(String idPlaylist, String idMidia) throws PlaylistNaoEncontradaException, MidiaNaoEncontradaException, PersistenciaException;
    void removerMidiaPlaylist(String idPlaylist, String idMidia) throws PlaylistNaoEncontradaException, MidiaNaoEncontradaException, PersistenciaException;
    Playlist buscarPlaylist(String id) throws PlaylistNaoEncontradaException;
    List<Playlist> listarPlaylists();

    // Favoritos
    void marcarMidiaComoFavorita(String idMidia, boolean status) throws MidiaNaoEncontradaException, PersistenciaException;
    List<ArquivoMidia> listarFavoritos();

    // Persistência
    void salvarBiblioteca() throws PersistenciaException;
}