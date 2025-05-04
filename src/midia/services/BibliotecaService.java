package midia.services;

import midia.models.*;
import midia.interfaces.*;
import midia.excecoes.*;
import midia.util.TipoMidia;
import java.util.*;
import java.util.stream.Collectors;

public class BibliotecaService implements IBibliotecaService {
    private final Biblioteca biblioteca;
    private final IPersistenciaService persistenciaService;
    private final String caminhoArquivo;

    public BibliotecaService(Biblioteca biblioteca, IPersistenciaService persistenciaService, String caminhoArquivo) {
        this.biblioteca = biblioteca;
        this.persistenciaService = persistenciaService;
        this.caminhoArquivo = caminhoArquivo;
    }

    // Adicionar mídias
    @Override
    public void adicionarMusica(Musica m) throws MidiaDuplicadaException, PersistenciaException {
        if (biblioteca.getTodasAsMidias().containsKey(m.getId())) {
            throw new MidiaDuplicadaException("Música já cadastrada!");
        }
        biblioteca.adicionarMidia(m);
        salvarBiblioteca();
    }

    @Override
    public void adicionarPodcast(PodcastEpisodio p) throws MidiaDuplicadaException, PersistenciaException {
        if (biblioteca.getTodasAsMidias().containsKey(p.getId())) {
            throw new MidiaDuplicadaException("Podcast já cadastrado!");
        }
        biblioteca.adicionarMidia(p);
        salvarBiblioteca();
    }

    @Override
    public void adicionarAudiobook(AudiobookCapitulo a) throws MidiaDuplicadaException, PersistenciaException {
        if (biblioteca.getTodasAsMidias().containsKey(a.getId())) {
            throw new MidiaDuplicadaException("Audiobook já cadastrado!");
        }
        biblioteca.adicionarMidia(a);
        salvarBiblioteca();
    }

    // Buscar mídia por ID
    @Override
    public ArquivoMidia buscarMidia(String id) throws MidiaNaoEncontradaException {
        ArquivoMidia m = biblioteca.getTodasAsMidias().get(id);
        if (m == null) throw new MidiaNaoEncontradaException("Mídia não encontrada!");
        return m;
    }

    // Buscar por título (contém, case-insensitive)
    @Override
    public List<ArquivoMidia> buscarMidiaPorTitulo(String titulo) {
        return biblioteca.getTodasAsMidias().values().stream()
                .filter(m -> m.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Buscar por termo e tipo
    @Override
    public List<ArquivoMidia> buscarMidia(String termoBusca, TipoMidia tipo) {
        return biblioteca.getTodasAsMidias().values().stream()
                .filter(m -> {
                    boolean match = m.getTitulo().toLowerCase().contains(termoBusca.toLowerCase());
                    switch (tipo) {
                        case MUSICA: return match && m instanceof Musica;
                        case PODCAST: return match && m instanceof PodcastEpisodio;
                        case AUDIOBOOK: return match && m instanceof AudiobookCapitulo;
                        default: return false;
                    }
                })
                .collect(Collectors.toList());
    }

    // Listar todas as mídias
    @Override
    public List<ArquivoMidia> listarTodasMidias() {
        return new ArrayList<>(biblioteca.getTodasAsMidias().values());
    }

    @Override
    public List<Musica> listarMusicas() {
        return biblioteca.getTodasAsMidias().values().stream()
                .filter(m -> m instanceof Musica)
                .map(m -> (Musica) m)
                .collect(Collectors.toList());
    }

    @Override
    public List<PodcastEpisodio> listarPodcasts() {
        return biblioteca.getTodasAsMidias().values().stream()
                .filter(m -> m instanceof PodcastEpisodio)
                .map(m -> (PodcastEpisodio) m)
                .collect(Collectors.toList());
    }

    @Override
    public List<AudiobookCapitulo> listarAudiobooks() {
        return biblioteca.getTodasAsMidias().values().stream()
                .filter(m -> m instanceof AudiobookCapitulo)
                .map(m -> (AudiobookCapitulo) m)
                .collect(Collectors.toList());
    }

    // Playlists
    @Override
    public void criarPlaylist(String nome, String descricao) throws MidiaDuplicadaException, PersistenciaException {
        boolean existe = biblioteca.getTodasAsPlaylists().values().stream()
                .anyMatch(p -> p.getNome().equalsIgnoreCase(nome));
        if (existe) throw new MidiaDuplicadaException("Já existe uma playlist com esse nome!");
        Playlist p = new Playlist(null, nome, descricao, new ArrayList<>());
        biblioteca.adicionarPlaylist(p);
        salvarBiblioteca();
    }

    @Override
    public void adicionarMidiaPlaylist(String idPlaylist, String idMidia)
            throws PlaylistNaoEncontradaException, MidiaNaoEncontradaException, PersistenciaException {
        Playlist p = biblioteca.getTodasAsPlaylists().get(idPlaylist);
        if (p == null) throw new PlaylistNaoEncontradaException("Playlist não encontrada!");
        ArquivoMidia m = biblioteca.getTodasAsMidias().get(idMidia);
        if (m == null) throw new MidiaNaoEncontradaException("Mídia não encontrada!");
        if (!p.getPlaylist().contains(m)) {
            p.getPlaylist().add(m);
            salvarBiblioteca();
        }
    }

    @Override
    public void removerMidiaPlaylist(String idPlaylist, String idMidia)
            throws PlaylistNaoEncontradaException, MidiaNaoEncontradaException, PersistenciaException {
        Playlist p = biblioteca.getTodasAsPlaylists().get(idPlaylist);
        if (p == null) throw new PlaylistNaoEncontradaException("Playlist não encontrada!");
        ArquivoMidia m = biblioteca.getTodasAsMidias().get(idMidia);
        if (m == null) throw new MidiaNaoEncontradaException("Mídia não encontrada!");
        p.getPlaylist().remove(m);
        salvarBiblioteca();
    }

    @Override
    public Playlist buscarPlaylist(String id) throws PlaylistNaoEncontradaException {
        Playlist p = biblioteca.getTodasAsPlaylists().get(id);
        if (p == null) throw new PlaylistNaoEncontradaException("Playlist não encontrada!");
        return p;
    }

    @Override
    public List<Playlist> listarPlaylists() {
        return new ArrayList<>(biblioteca.getTodasAsPlaylists().values());
    }

    // Favoritos
    @Override
    public void marcarMidiaComoFavorita(String idMidia, boolean status)
            throws MidiaNaoEncontradaException, PersistenciaException {
        ArquivoMidia m = biblioteca.getTodasAsMidias().get(idMidia);
        if (m == null) throw new MidiaNaoEncontradaException("Mídia não encontrada!");
        m.marcarFavorito(status);
        salvarBiblioteca();
    }

    @Override
    public List<ArquivoMidia> listarFavoritos() {
        return biblioteca.getTodasAsMidias().values().stream()
                .filter(ArquivoMidia::isFavorito)
                .collect(Collectors.toList());
    }

    // Persistência
    @Override
    public void salvarBiblioteca() throws PersistenciaException {
        persistenciaService.salvar(biblioteca, caminhoArquivo);
    }
}