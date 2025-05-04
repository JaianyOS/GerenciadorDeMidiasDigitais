package midia.excecoes;

// excecao personalizada pra playlist nao encontrada
public class PlaylistNaoEncontradaException extends Exception {
    public PlaylistNaoEncontradaException(String msg) { super(msg); }
}