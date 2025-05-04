package midia.excecoes;

// excecao personalizada pra midia nao encontrada

public class MidiaNaoEncontradaException extends Exception {
    public MidiaNaoEncontradaException(String msg) { super(msg); }
}