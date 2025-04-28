## Documentação do Projeto: Gerenciador de Biblioteca de Mídia Digital

### 1. Conceito do Sistema

O sistema "Gerenciador de Biblioteca de Mídia Digital" permite aos usuários catalogar, organizar, pesquisar e gerenciar seus arquivos de áudio digitais pessoais, como músicas, episódios de podcast e capítulos de audiobook. Ele oferece funcionalidades para adicionar novas mídias, criar e gerenciar playlists, buscar itens na biblioteca e persistir o estado da biblioteca em arquivos para uso futuro. O sistema é operado através de um menu de console interativo.

### 2. Atendimento aos Requisitos do Trabalho Prático 02

Vamos verificar cada requisito do PDF:

1.  **Entrega:** Conforme especificado (ZIP com .java, nome `Trabalho_pratico_02-GrupoX.zip`, comentário no cabeçalho com nomes/matrículas).
2.  **Objetivo:** Implementação de um sistema OO para resolver um problema real (gerenciamento de mídia). OK.
3.  **Mínimo 6 Classes Instanciáveis:**
    *   `Musica` (Herda de `ArquivoMidia`)
    *   `PodcastEpisodio` (Herda de `ArquivoMidia`)
    *   `AudiobookCapitulo` (Herda de `ArquivoMidia`)
    *   `Playlist`
    *   `BibliotecaService` (Controlador/Lógica de Negócio)
    *   `PersistenciaService` (Gerencia salvamento/carregamento)
    *   `MenuUI` (Interação com usuário)
    *   `Biblioteca` (Contêiner de dados)
    *   *Total:* 8 classes instanciáveis, atendendo e superando o requisito de 6.
4.  **1 Estrutura de Herança:**
    *   `ArquivoMidia` (Abstrata) -> `Musica`, `PodcastEpisodio`, `AudiobookCapitulo`. OK.
    *   *Justificativa Filhas:* As classes filhas (`Musica`, `PodcastEpisodio`, `AudiobookCapitulo`) possuem atributos e métodos específicos (`Artista/Album`, `NomePodcast/NumEpisodio`, `NomeLivro/Autor/NumCapitulo`, e implementações de `play()` e `getDetalhesExibicao()`) que justificam a herança e não são apenas construtores. OK.
5.  **1 Classe Abstrata:** `ArquivoMidia`. OK.
6.  **1 Método Abstrato:** `getDetalhesExibicao()` em `ArquivoMidia`. OK.
7.  **2 Interfaces:**
    *   `IReproduzivel` (com método `play()`)
    *   `IFavoritavel` (com métodos `marcarFavorito(boolean)` e `isFavorito()`)
    *   *Extra (Boas Práticas/SOLID):* `IBibliotecaService`, `IPersistenciaService`. Total de 4 interfaces. OK.
8.  **2 Sobrecargas de Métodos (não construtores):**
    *   Em `BibliotecaService`: `buscarMidia(String titulo)` e `buscarMidia(String termoBusca, TipoMidia tipo)`. OK. (Ou alternativas como `adicionarMidia(Musica m)` e `adicionarMidia(PodcastEpisodio p)`).
9.  **4 Sobrescritas de Métodos:**
    *   `getDetalhesExibicao()`: Sobrescrito em `Musica`, `PodcastEpisodio`, `AudiobookCapitulo`. (3)
    *   `play()`: Sobrescrito em `Musica`, `PodcastEpisodio`, `AudiobookCapitulo`. (3)
    *   `toString()`: Sobrescrito em `ArquivoMidia` (base), `Musica`, `PodcastEpisodio`, `AudiobookCapitulo`, `Playlist`. (5+)
    *   *Total:* Múltiplas sobrescritas, atendendo ao requisito. OK.
10. **Implementação em Java:** OK.
11. **Conceitos de POO:** Herança, Polimorfismo, Encapsulamento, Abstração, Interfaces. OK.
12. **Formatar e Comentar:** OK (a ser feito na implementação).
13. **Boas Práticas:** Uso de interfaces, `final`, `private`, tratamento de exceções específico, `Serializable`, `hashCode`/`equals` (importante para coleções e evitar duplicatas), principios SOLID. OK.
14. **Classes em Arquivos Separados:** OK.
15. **Menu Interativo:** Implementado pela classe `MenuUI`. OK.
16. **Módulo de Salvar/Carregar (Persistência):** Implementado pela classe `PersistenciaService` utilizando serialização Java para salvar/carregar o objeto `Biblioteca` em um arquivo binário (`biblioteca.dat`). OK.
17. **Carregamento Automático ao Iniciar:** A classe `Main` orquestra o carregamento dos dados via `PersistenciaService` antes de iniciar o `MenuUI`. OK.
18. **Carga Inicial via Arquivo (NÃO CÓDIGO):** O sistema deve ser executado uma vez, dados adicionados, e o arquivo `biblioteca.dat` gerado deve ser incluído na entrega. O código *não* terá dados "hardcoded" para a carga inicial. OK.
19. **Tratamento de Exceções:**
    *   **Mínimo 3 Exceções Específicas:**
        1.  `MidiaNaoEncontradaException` (Erro ao buscar/remover mídia inexistente).
        2.  `PlaylistNaoEncontradaException` (Erro ao buscar/modificar playlist inexistente).
        3.  `EntradaInvalidaException` (Erro de formato na entrada do usuário, ex: texto onde se espera número).
    *   **1 Exceção Customizada de Negócio:**
        1.  `MidiaDuplicadaException` (Tentativa de adicionar uma mídia que já existe, baseado em ID ou combinação de atributos).
    *   **Evitar `Exception e`:** Usar `catch` específicos ou as exceções customizadas. OK.
20. **Funcionalidades do Menu:** Todas as opções implementadas e funcionais. OK (a ser garantido na implementação e testes).

### 3. Aplicação dos Princípios SOLID

*   **S (Single Responsibility Principle - Princípio da Responsabilidade Única):**
    *   `ArquivoMidia` e subclasses: Representam os dados e comportamento intrínseco de cada tipo de mídia.
    *   `Playlist`: Gerencia a coleção de mídias de uma playlist específica.
    *   `Biblioteca`: Contém as coleções de mídias e playlists (estado da aplicação).
    *   `BibliotecaService`: Orquestra as operações na biblioteca (lógica de negócio).
    *   `PersistenciaService`: Responsável unicamente por salvar e carregar o estado da `Biblioteca`.
    *   `MenuUI`: Responsável unicamente pela interação com o usuário (apresentação e captura de entrada).
    *   `Main`: Ponto de entrada, inicialização e coordenação inicial.
*   **O (Open/Closed Principle - Princípio Aberto/Fechado):**
    *   Adicionar um novo tipo de mídia (ex: `VideoClipe`) exigiria criar uma nova classe herdando `ArquivoMidia` e implementar seus métodos. As classes `BibliotecaService` e `MenuUI` precisariam de modificações mínimas (graças ao polimorfismo e talvez adição de opções no menu), mas o núcleo da lógica existente permaneceria inalterado. O uso de interfaces (`IBibliotecaService`, `IPersistenciaService`) também facilita a extensão ou substituição de implementações.
*   **L (Liskov Substitution Principle - Princípio da Substituição de Liskov):**
    *   Qualquer instância de `Musica`, `PodcastEpisodio` ou `AudiobookCapitulo` pode ser usada onde um `ArquivoMidia` é esperado (ex: em listas `List<ArquivoMidia>` dentro de `Playlist` ou `Biblioteca`), sem quebrar a lógica que utiliza `ArquivoMidia`. Os métodos sobrescritos (`play`, `getDetalhesExibicao`, `toString`) mantêm um contrato comportamental consistente.
*   **I (Interface Segregation Principle - Princípio da Segregação de Interfaces):**
    *   As interfaces (`IReproduzivel`, `IFavoritavel`, `IBibliotecaService`, `IPersistenciaService`) são pequenas e focadas em funcionalidades específicas. Clientes (classes que usam as interfaces) não são forçados a depender de métodos que não utilizam.
*   **D (Dependency Inversion Principle - Princípio da Inversão de Dependência):**
    *   Módulos de alto nível (`MenuUI`, `Main`) dependem de abstrações (`IBibliotecaService`, `IPersistenciaService`) e não de implementações concretas (`BibliotecaService`, `PersistenciaService`).
    *   Módulos de baixo nível (`BibliotecaService`, `PersistenciaService`) também dependem de abstrações (embora neste caso `PersistenciaService` possa operar diretamente sobre a classe concreta `Biblioteca` para serialização, ou poderia receber uma interface `IBibliotecaData` se quiséssemos abstrair ainda mais). A injeção de dependência (passando instâncias de serviços via construtor ou métodos) seria a forma de implementar isso.

### 4. Estrutura do Projeto (Classes e Interfaces)

*   **`com.biblioteca.midia.entidades`** (Pacote para modelos de dados)
    *   **`ArquivoMidia` (abstract class):**
        *   Atributos: `id` (String/UUID, final), `titulo` (String), `duracaoSegundos` (int), `caminhoArquivo` (String), `formato` (String), `favorito` (boolean).
        *   Métodos: Construtor, getters, `marcarFavorito(boolean)`, `isFavorito()`, `toString()` (override), `hashCode()` (override), `equals()` (override).
        *   Método Abstrato: `getDetalhesExibicao()`
        *   Implementa: `IReproduzivel`, `IFavoritavel`, `Serializable`.
    *   **`Musica` (class):**
        *   Herda: `ArquivoMidia`.
        *   Atributos: `artista` (String), `album` (String), `genero` (String), `anoLancamento` (int).
        *   Métodos: Construtor, getters, `play()` (override), `getDetalhesExibicao()` (override), `toString()` (override).
        *   Implementa: `Serializable`.
    *   **`PodcastEpisodio` (class):**
        *   Herda: `ArquivoMidia`.
        *   Atributos: `nomePodcast` (String), `numeroEpisodio` (int), `dataPublicacao` (LocalDate), `descricaoResumida` (String).
        *   Métodos: Construtor, getters, `play()` (override), `getDetalhesExibicao()` (override), `toString()` (override).
        *   Implementa: `Serializable`.
    *   **`AudiobookCapitulo` (class):**
        *   Herda: `ArquivoMidia`.
        *   Atributos: `nomeLivro` (String), `nomeAutor` (String), `numeroCapitulo` (int).
        *   Métodos: Construtor, getters, `play()` (override), `getDetalhesExibicao()` (override), `toString()` (override).
        *   Implementa: `Serializable`.
    *   **`Playlist` (class):**
        *   Atributos: `id` (String/UUID, final), `nome` (String), `descricao` (String), `listaMidias` (List<ArquivoMidia>).
        *   Métodos: Construtor, getters, `adicionarMidia(ArquivoMidia)`, `removerMidia(ArquivoMidia)`, `getDuracaoTotal()`, `toString()` (override).
        *   Implementa: `Serializable`.
    *   **`Biblioteca` (class):**
        *   Atributos: `todasAsMidias` (Map<String, ArquivoMidia>), `todasAsPlaylists` (Map<String, Playlist>). (Usar Map facilita busca/remoção por ID e evita duplicatas de ID).
        *   Métodos: Construtor, getters (retornando cópias defensivas ou vistas não modificáveis das coleções), métodos para adicionar/remover/obter mídias e playlists *internamente* (usados pelo `BibliotecaService`).
        *   Implementa: `Serializable`.

*   **`com.biblioteca.midia.interfaces`** (Pacote para interfaces)
    *   **`IReproduzivel` (interface):**
        *   Métodos: `void play();`
    *   **`IFavoritavel` (interface):**
        *   Métodos: `void marcarFavorito(boolean status);`, `boolean isFavorito();`
    *   **`IBibliotecaService` (interface):**
        *   Métodos: `void adicionarMusica(...)`, `void adicionarPodcast(...)`, `void adicionarAudiobook(...)`, `ArquivoMidia buscarMidia(String id)`, `List<ArquivoMidia> buscarMidiaPorTitulo(String titulo)`, `List<ArquivoMidia> buscarMidia(String termoBusca, TipoMidia tipo)`, `List<ArquivoMidia> listarTodasMidias()`, `List<Musica> listarMusicas()`, `List<PodcastEpisodio> listarPodcasts()`, ... , `void criarPlaylist(String nome, String descricao)`, `void adicionarMidiaPlaylist(String idPlaylist, String idMidia)`, `void removerMidiaPlaylist(String idPlaylist, String idMidia)`, `Playlist buscarPlaylist(String id)`, `List<Playlist> listarPlaylists()`, `void marcarMidiaComoFavorita(String idMidia, boolean status)`, `List<ArquivoMidia> listarFavoritos()`, `void salvarBiblioteca()`.
    *   **`IPersistenciaService` (interface):**
        *   Métodos: `void salvar(Biblioteca biblioteca, String caminhoArquivo) throws PersistenciaException;`, `Biblioteca carregar(String caminhoArquivo) throws PersistenciaException;`

*   **`com.biblioteca.midia.servicos`** (Pacote para serviços/lógica)
    *   **`BibliotecaService` (class):**
        *   Atributos: `biblioteca` (Biblioteca), `persistenciaService` (IPersistenciaService), `caminhoArquivo` (String).
        *   Métodos: Construtor (recebe `IPersistenciaService`, `Biblioteca`, `caminhoArquivo`), implementa todos os métodos de `IBibliotecaService`. Realiza validações, lança exceções (`MidiaNaoEncontradaException`, `PlaylistNaoEncontradaException`, `MidiaDuplicadaException`). Contém as sobrecargas de `buscarMidia`. Chama `persistenciaService.salvar()` após operações de modificação.
    *   **`PersistenciaService` (class):**
        *   Métodos: Implementa `IPersistenciaService`. Usa `ObjectOutputStream` e `ObjectInputStream` para serializar/desserializar o objeto `Biblioteca`. Lança `PersistenciaException` (wrapper para `IOException`, `ClassNotFoundException`, etc.).

*   **`com.biblioteca.midia.ui`** (Pacote para interface com usuário)
    *   **`MenuUI` (class):**
        *   Atributos: `bibliotecaService` (IBibliotecaService), `scanner` (Scanner).
        *   Métodos: Construtor (recebe `IBibliotecaService`), `exibirMenuPrincipal()`, `processarOpcao(int)`, `lerEntradaUsuario()`, métodos auxiliares para cada funcionalidade (ex: `uiAdicionarMusica()`, `uiListarMidias()`, `uiBuscarMidia()`). Trata `InputMismatchException` e lança/propaga `EntradaInvalidaException`. Interage com `BibliotecaService`.

*   **`com.biblioteca.midia.excecoes`** (Pacote para exceções customizadas)
    *   `MidiaNaoEncontradaException` (extends Exception)
    *   `PlaylistNaoEncontradaException` (extends Exception)
    *   `EntradaInvalidaException` (extends Exception)
    *   `MidiaDuplicadaException` (extends Exception)
    *   `PersistenciaException` (extends Exception)

*   **`com.biblioteca.midia`** (Pacote raiz)
    *   **`Main` (class):**
        *   Método `main(String[] args)`:
            1.  Define `CAMINHO_ARQUIVO = "biblioteca.dat"`.
            2.  Cria instância de `PersistenciaService`.
            3.  Tenta carregar a `Biblioteca` usando `persistenciaService.carregar()`.
                *   Se falhar (ex: `PersistenciaException` por arquivo não encontrado na primeira execução), cria uma `Biblioteca` vazia.
            4.  Cria instância de `BibliotecaService` passando a `Biblioteca` carregada/criada, o `persistenciaService` e o `CAMINHO_ARQUIVO`.
            5.  Cria instância de `MenuUI` passando o `bibliotecaService`.
            6.  Inicia o loop do menu chamando `menuUI.exibirMenuPrincipal()`.

*   **`com.biblioteca.midia.util`** (Pacote opcional para utilitários)
    *   **`TipoMidia` (enum):** MUSICA, PODCAST, AUDIOBOOK (pode ser útil para buscas filtradas).
    *   **`GeradorID` (class):** Classe utilitária (ex: com método estático) para gerar IDs únicos (ex: `UUID.randomUUID().toString()`).

### 5. Diagrama de Classes (Simplificado - Mermaid Syntax)

```mermaid
classDiagram
    direction LR

    class ArquivoMidia {
        <<Abstract>>
        +String id
        +String titulo
        +int duracaoSegundos
        +String caminhoArquivo
        +String formato
        #boolean favorito
        +getDetalhesExibicao()* String
        +play()* void
        +marcarFavorito(boolean status) void
        +isFavorito() boolean
        +toString() String
    }
    ArquivoMidia --|> IReproduzivel : implements
    ArquivoMidia --|> IFavoritavel : implements
    ArquivoMidia --|> Serializable : implements

    class Musica {
        +String artista
        +String album
        +String genero
        +int anoLancamento
        +getDetalhesExibicao() String
        +play() void
        +toString() String
    }
    Musica --|> ArquivoMidia : extends

    class PodcastEpisodio {
        +String nomePodcast
        +int numeroEpisodio
        +LocalDate dataPublicacao
        +String descricaoResumida
        +getDetalhesExibicao() String
        +play() void
        +toString() String
    }
    PodcastEpisodio --|> ArquivoMidia : extends

    class AudiobookCapitulo {
        +String nomeLivro
        +String nomeAutor
        +int numeroCapitulo
        +getDetalhesExibicao() String
        +play() void
        +toString() String
    }
    AudiobookCapitulo --|> ArquivoMidia : extends

    class Playlist {
        +String id
        +String nome
        +String descricao
        +List~ArquivoMidia~ listaMidias
        +adicionarMidia(ArquivoMidia)
        +removerMidia(ArquivoMidia)
        +getDuracaoTotal() int
    }
    Playlist --|> Serializable : implements
    Playlist "1" *-- "0..*" ArquivoMidia : contém

    class Biblioteca {
        -Map~String, ArquivoMidia~ todasAsMidias
        -Map~String, Playlist~ todasAsPlaylists
    }
    Biblioteca --|> Serializable : implements
    Biblioteca "1" *-- "0..*" ArquivoMidia : agrega
    Biblioteca "1" *-- "0..*" Playlist : agrega

    interface IReproduzivel {
        <<Interface>>
        +play() void
    }

    interface IFavoritavel {
        <<Interface>>
        +marcarFavorito(boolean status) void
        +isFavorito() boolean
    }

    interface IBibliotecaService {
        <<Interface>>
        +adicionarMusica(...) void
        +adicionarPodcast(...) void
        +adicionarAudiobook(...) void
        +buscarMidia(String id) ArquivoMidia
        +buscarMidiaPorTitulo(String titulo) List~ArquivoMidia~
        +listarTodasMidias() List~ArquivoMidia~
        +criarPlaylist(String nome, String desc) void
        +adicionarMidiaPlaylist(String pId, String mId) void
        +buscarPlaylist(String id) Playlist
        +listarPlaylists() List~Playlist~
        +marcarMidiaComoFavorita(String id, boolean status) void
        +salvarBiblioteca() void
        +...(outros métodos)
    }

    interface IPersistenciaService {
        <<Interface>>
        +salvar(Biblioteca b, String path) void
        +carregar(String path) Biblioteca
    }

    class BibliotecaService {
        -Biblioteca biblioteca
        -IPersistenciaService persistenciaService
        -String caminhoArquivo
        +...(implementa IBibliotecaService)
    }
    BibliotecaService ..|> IBibliotecaService : implements
    BibliotecaService --> Biblioteca : usa
    BibliotecaService --> IPersistenciaService : usa

    class PersistenciaService {
        +salvar(Biblioteca b, String path) void
        +carregar(String path) Biblioteca
    }
    PersistenciaService ..|> IPersistenciaService : implements
    PersistenciaService ..> Biblioteca : serializa/desserializa

    class MenuUI {
        -IBibliotecaService bibliotecaService
        -Scanner scanner
        +exibirMenuPrincipal() void
        +processarOpcao(int) void
    }
    MenuUI --> IBibliotecaService : usa

    class Main {
        +main(String[] args) void
    }
    Main --> MenuUI : cria/usa
    Main --> BibliotecaService : cria
    Main --> PersistenciaService : cria/usa

    ' Exceções (não usualmente mostradas em diagramas de classe principais)
    class MidiaNaoEncontradaException
    class PlaylistNaoEncontradaException
    class EntradaInvalidaException
    class MidiaDuplicadaException
    class PersistenciaException
    MidiaNaoEncontradaException --|> Exception : extends
    PlaylistNaoEncontradaException --|> Exception : extends
    EntradaInvalidaException --|> Exception : extends
    MidiaDuplicadaException --|> Exception : extends
    PersistenciaException --|> Exception : extends

    BibliotecaService ..> MidiaNaoEncontradaException : throws
    BibliotecaService ..> PlaylistNaoEncontradaException : throws
    BibliotecaService ..> MidiaDuplicadaException : throws
    PersistenciaService ..> PersistenciaException : throws
    MenuUI ..> EntradaInvalidaException : throws
```

### 6. Estratégia de Persistência

*   **Tecnologia:** Serialização de Objetos Java.
*   **Arquivo:** Um único arquivo binário (ex: `biblioteca.dat`).
*   **Objeto Salvo:** A instância da classe `Biblioteca`, que contém todas as mídias e playlists.
*   **Processo:**
    *   **Salvar:** A classe `PersistenciaService` utiliza `FileOutputStream` e `ObjectOutputStream` para escrever o objeto `Biblioteca` no arquivo. Chamado pelo `BibliotecaService` após operações que modificam o estado.
    *   **Carregar:** A classe `PersistenciaService` utiliza `FileInputStream` e `ObjectInputStream` para ler o objeto `Biblioteca` do arquivo. Chamado pela classe `Main` na inicialização.
*   **Tratamento de Erros:** A `PersistenciaService` encapsula `IOExceptions`, `ClassNotFoundException`, etc., em uma `PersistenciaException` customizada para ser tratada na `Main` (ex: iniciar com biblioteca vazia se o arquivo não for encontrado).
*   **Importante:** Todas as classes que fazem parte do objeto `Biblioteca` (incluindo `ArquivoMidia` e suas subclasses, `Playlist`) devem implementar a interface `java.io.Serializable`.

### 7. Estratégia de Tratamento de Exceções

*   **Exceções Customizadas:** Criar classes específicas (`MidiaNaoEncontradaException`, `PlaylistNaoEncontradaException`, `MidiaDuplicadaException`, `EntradaInvalidaException`, `PersistenciaException`) herdando de `Exception` (ou `RuntimeException` se apropriado, mas `Exception` força o tratamento).
*   **Lançamento:**
    *   `BibliotecaService`: Lança `MidiaNaoEncontradaException`, `PlaylistNaoEncontradaException`, `MidiaDuplicadaException` quando as regras de negócio ou buscas falham.
    *   `PersistenciaService`: Lança `PersistenciaException` para erros de I/O ou desserialização.
    *   `MenuUI`: Lança (ou trata internamente e relança) `EntradaInvalidaException` para input malformado do usuário (ex: `InputMismatchException` do `Scanner`).
*   **Captura:**
    *   `MenuUI`: Captura exceções lançadas pelo `BibliotecaService` e `EntradaInvalidaException` para exibir mensagens de erro amigáveis ao usuário, sem terminar o programa abruptamente.
    *   `Main`: Captura `PersistenciaException` durante o carregamento inicial para lidar com a ausência do arquivo de dados.
*   **Evitar `catch (Exception e)`:** Usar blocos `catch` específicos para cada tipo de exceção esperada, permitindo tratamento diferenciado e mais robusto.

### 8. Estrutura do Menu (Exemplo)

```
=== Gerenciador de Mídia Digital ===
1. Adicionar Mídia
2. Listar Mídias
3. Buscar Mídia
4. Gerenciar Playlists
5. Marcar/Desmarcar Favorito
6. Listar Favoritos
7. Salvar e Sair
Escolha uma opção:

--- Submenu Adicionar Mídia ---
1. Adicionar Música
2. Adicionar Podcast
3. Adicionar Audiobook
Voltar [0]

--- Submenu Listar Mídias ---
1. Listar Todas
2. Listar Músicas
3. Listar Podcasts
4. Listar Audiobooks
Voltar [0]

--- Submenu Buscar Mídia ---
1. Buscar por ID
2. Buscar por Título
3. Buscar por Artista (Música)
4. Buscar por Nome do Podcast
...
Voltar [0]

--- Submenu Gerenciar Playlists ---
1. Criar Nova Playlist
2. Listar Playlists
3. Ver Detalhes da Playlist (e suas mídias)
4. Adicionar Mídia à Playlist
5. Remover Mídia da Playlist
6. Excluir Playlist
Voltar [0]
```

### 9. Instruções para Geração da Carga Inicial

1.  Compile e execute o programa (`Main.java`).
2.  Utilize as opções do menu para adicionar alguns exemplos de Músicas, Podcasts e Audiobooks.
3.  Crie pelo menos uma Playlist e adicione algumas mídias a ela.
4.  Marque algumas mídias como favoritas.
5.  Escolha a opção "Salvar e Sair" no menu principal. Isso criará/atualizará o arquivo `biblioteca.dat` no diretório de execução.
6.  **Inclua este arquivo `biblioteca.dat` junto com os arquivos `.java` no arquivo `.zip` final da entrega.** O sistema, ao ser executado pelo avaliador, carregará automaticamente estes dados.

Esta estrutura detalhada e o design proposto atendem a todos os requisitos do PDF, incorporando boas práticas e os princípios SOLID para criar um sistema mais robusto, manutenível e extensível.
