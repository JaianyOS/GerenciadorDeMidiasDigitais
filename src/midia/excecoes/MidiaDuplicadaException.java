package midia.excecoes;

// excecao personalizada pra midia duplicada

public class MidiaDuplicadaException extends Exception {
    public MidiaDuplicadaException(String msg) { super(msg); }
}