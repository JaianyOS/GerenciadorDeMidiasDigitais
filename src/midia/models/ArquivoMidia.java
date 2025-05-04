package midia.models;

import midia.interfaces.IFavoritavel;
import midia.interfaces.IReproduzivel;
import midia.util.GeradorID;

import java.io.Serializable;

// arquivo midia implementa as interfaces pra sobrescrever os métodos de contrato.
// importante: como é a "classe mãe", as subclasses que vão herdar essa classe abstrata também já
// contam como serializáveis.

// importante tambem: apesar de as classes filhas nao terem tantos métodos diferentes da classe mãe,
// os atributos justificam a divisão, afinal, os arquivos de mídia que herdam dessa classe não
// possuem as mesmas características (atributos) e não existe sentido pra que possuam.

public abstract class ArquivoMidia implements IReproduzivel, IFavoritavel, Serializable {
    private String id;
    private String titulo;
    private int duracaoSegundos;
    private String caminhoArquivo;
    private String formato;
    private boolean favorito;

    public ArquivoMidia(String id, String titulo, int duracaoSegundos, String caminhoArquivo, String formato, boolean favorito) {
        // o id vai ser gerado automaticamente a partir do método estático da classe GeradorID. Formato: UUID convertido p string
        this.id = GeradorID.novoID();
        this.titulo = titulo;
        this.duracaoSegundos = duracaoSegundos;
        this.caminhoArquivo = caminhoArquivo;
        this.formato = formato;
        this.favorito = favorito;
    }

    // métodos de getters e setters padrão, pra seguir o bean (ainda que os setters não estejam sendo majoritariamente utilizados)

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public void setDuracaoSegundos(int duracaoSegundos) {
        this.duracaoSegundos = duracaoSegundos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // implementação da interface IFavoritavel

    @Override
    public boolean isFavorito() {
        return favorito;
    }

    @Override
    public void marcarFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    // métodos abstratos

    // implementação da interface IReproduzivel
    @Override
    public abstract void play();

    // método abstrato da classe de arquivo mdiia que vai ser implementado pelas subclasses, assim como play também
    public abstract String getDetalhesExibicao();
}
