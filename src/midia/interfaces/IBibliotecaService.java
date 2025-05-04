package midia.interfaces;

import midia.models.*;
import midia.excecoes.*;
import midia.util.TipoMidia;
import java.util.List;


public interface IBibliotecaService {
    // Métodos para adicionar mídias individualmente
    void adicionarMusica(Musica m) throws MidiaDuplicadaException, PersistenciaException;
    void adicionarPodcast(PodcastEpisodio p) throws MidiaDuplicadaException, PersistenciaException;
    void adicionarAudiobook(AudiobookCapitulo a) throws MidiaDuplicadaException, PersistenciaException;

    // Sobrecargas: adicionar várias mídias de uma vez (operações em lote)
    void adicionarMusica(List<Musica> musicas) throws MidiaDuplicadaException, PersistenciaException;
    void adicionarPodcast(List<PodcastEpisodio> podcasts) throws MidiaDuplicadaException, PersistenciaException;
    void adicionarAudiobook(List<AudiobookCapitulo> audiobooks) throws MidiaDuplicadaException, PersistenciaException;

    // Métodos para buscar mídias
    ArquivoMidia buscarMidia(String id) throws MidiaNaoEncontradaException;
    List<ArquivoMidia> buscarMidiaPorTitulo(String titulo);
    List<ArquivoMidia> buscarMidia(String termoBusca, TipoMidia tipo);

    // Sobrecarga: buscar várias mídias por uma lista de IDs
    List<ArquivoMidia> buscarMidia(List<String> ids) throws MidiaNaoEncontradaException;

    // Listar mídias
    List<ArquivoMidia> listarTodasMidias();
    List<Musica> listarMusicas();
    List<PodcastEpisodio> listarPodcasts();
    List<AudiobookCapitulo> listarAudiobooks();

    // Playlists
    void criarPlaylist(String nome, String descricao) throws MidiaDuplicadaException, PersistenciaException;
    void adicionarMidiaPlaylist(String idPlaylist, String idMidia)
            throws PlaylistNaoEncontradaException, MidiaNaoEncontradaException, PersistenciaException;
    void removerMidiaPlaylist(String idPlaylist, String idMidia)
            throws PlaylistNaoEncontradaException, MidiaNaoEncontradaException, PersistenciaException;
    Playlist buscarPlaylist(String id) throws PlaylistNaoEncontradaException;
    List<Playlist> listarPlaylists();

    // Sobrecargas: adicionar/remover várias mídias em uma playlist
    void adicionarMidiaPlaylist(String idPlaylist, List<String> idsMidia)
            throws PlaylistNaoEncontradaException, MidiaNaoEncontradaException, PersistenciaException;
    void removerMidiaPlaylist(String idPlaylist, List<String> idsMidia)
            throws PlaylistNaoEncontradaException, MidiaNaoEncontradaException, PersistenciaException;

    // Favoritos
    void marcarMidiaComoFavorita(String idMidia, boolean status)
            throws MidiaNaoEncontradaException, PersistenciaException;
    List<ArquivoMidia> listarFavoritos();

    // Sobrecarga: marcar várias mídias como favoritas/deixar de favoritas
    void marcarMidiaComoFavorita(List<String> idsMidia, boolean status)
            throws MidiaNaoEncontradaException, PersistenciaException;

    // Persistência
    void salvarBiblioteca() throws PersistenciaException;
}