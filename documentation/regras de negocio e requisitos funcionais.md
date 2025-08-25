
**Definição do Projeto – App de Notícias (scroll tipo TikTok em Kotlin)**

----------

### **1. Objetivo do Projeto**

Criar um aplicativo mobile em Kotlin (Android) que consome uma API de notícias e exibe os artigos em formato de rolagem vertical em tela cheia, semelhante ao TikTok, priorizando a experiência de consumo rápido de conteúdo.

----------

### **2. Público-Alvo**

-   Usuários que desejam consumir notícias de forma rápida e dinâmica.
    
-   Pessoas interessadas em atualizações de diferentes áreas (tecnologia, esportes, política, entretenimento).
    

----------

### **3. Regras de Negócio**

1.  O app deve consumir notícias de uma **API externa de notícias** (exemplo: [NewsAPI](https://newsapi.org/), GNews, etc.).
    
2.  As notícias serão exibidas **uma por vez, em tela cheia**, com rolagem vertical (formato feed infinito).
    
3.  Cada notícia deve conter:
    
    -   Imagem destacada (se existir).
        
    -   Título.
        
    -   Fonte / Autor.
        
    -   Data da publicação.
        
    -   Resumo/Descrição curta.
        
    -   Link “Leia mais” que abre no navegador.
        
4.  O usuário poderá **curtir** ou **salvar** notícias para ler depois.
    
5.  Notícias salvas devem ser armazenadas localmente (SQLite/Room ou DataStore).
    
6.  O feed deve ser **atualizado periodicamente** (ex: a cada refresh manual ou ao abrir o app).
    
7.  O app deve ter um sistema de **categorias/filtragem** (ex.: tecnologia, esportes, saúde, etc.).
    
8.  Se não houver conexão com a internet:
    
    -   Exibir mensagem de erro.
        
    -   Mostrar apenas as notícias salvas offline.
        

----------

### **4. Requisitos Funcionais**

**RF01** – O sistema deve consumir dados de uma API de notícias.  
**RF02** – O sistema deve exibir as notícias em formato vertical de tela cheia (um artigo por vez).  
**RF03** – O usuário deve poder navegar entre notícias por rolagem vertical.  
**RF04** – O sistema deve exibir informações principais: título, imagem, fonte, data e resumo.  
**RF05** – O sistema deve permitir que o usuário abra a notícia completa no navegador.  
**RF06** – O sistema deve permitir salvar notícias para leitura posterior.  
**RF07** – O sistema deve permitir curtir notícias.  
**RF08** – O sistema deve armazenar localmente as notícias salvas.  
**RF09** – O sistema deve permitir filtrar notícias por categoria.  
**RF10** – O sistema deve funcionar parcialmente offline (mostrar salvas).  
**RF11** – O sistema deve ter tela de configuração básica (idioma, preferências de categoria).

----------

### **5. Requisitos Não Funcionais**

-   **RNF01** – O app deve ser desenvolvido em **Kotlin**.
    
-   **RNF02** – Interface deve seguir princípios de **UI/UX mobile-first** (inspirado em TikTok/Reels).
    
-   **RNF03** – Deve utilizar arquitetura **MVVM** com **ViewModel + LiveData/Flow**.
    
-   **RNF04** – Deve usar **Retrofit** para consumir a API.
    
-   **RNF05** – Deve usar **Coil ou Glide** para carregar imagens.
    
-   **RNF06** – Deve usar **Room** ou **DataStore** para armazenamento local.
    
-   **RNF07** – Performance otimizada para rolagem fluida.
    
-   **RNF08** – Compatibilidade mínima: Android 8 (API 26).
    