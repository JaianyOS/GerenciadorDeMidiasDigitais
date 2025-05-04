package midia.excecoes;

// excecao personalizada pra problema de persistencia

public class PersistenciaException extends Exception {
    public PersistenciaException(String msg) { super(msg); }
    public PersistenciaException(String msg, Throwable cause) { super(msg, cause); }
}