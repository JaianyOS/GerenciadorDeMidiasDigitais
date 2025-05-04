package midia.util;

import java.util.UUID;

public class GeradorID {
    public static String novoID() {
        return UUID.randomUUID().toString();
    }
}