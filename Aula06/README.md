# Aula 06 #

Sexta aula do minicurso "Introdução à plataforma Android", ministrada no dia 15/05/15 para os cursos de Ciência da Computação e Sistemas de Informação da UNIVEM.

### Conteúdo da aula ###

* Utilizar SharedPreferences para armazenar dados sobre o usuário (aceite de termos de uso e email)

### Conteúdo do repositório ###

* Projeto criado no Android Studio contendo

    * Resource:
        * **activity_main**: tela com os termos de uso da aplicação e uma caixa de texto para cadastro de email do usuário
        * **activity_list_usuario**: tela com uma lista de usuários e um botão para adicionar um novo usuário à lista
        * **activity_cadastro**: tela para cadastro de um usuário
        * **activity_detalhes**: tela que exibe os detalhes de um usuário
        * **item_list_usuario**: molde para preencher a lista de usuários
    * Activity:
        * **MainActivity**: Tela exibida somente uma vez (caso o usuário aceite os termos). Armazena em um SharedPreferences o aceite dos termos de uso e o email do usuário.
        * **ListUsuarioActivPossui uma lista de usuários, criada através de um **UsuarioAdapter**. Ao clicar em um item da lista, inicia a **DetalhesActivity**, enviando um **Usuario** como parâmetro. Ao clicar no botão de adicionar, inicia a **CadastroActivity**, esperando um **Usuario** como resultado. ity**: 
        * **CadastroActivity**: Armazena todas as informações digitadas em um objeto **Usuario**, e retorna como um resultado
        * **DetalhesActivity**: Recebe um **Usuario** como parâmetro e exibe suas informações
        * **Usuario**: Classe que representa um usuário
        * **UsuarioAdapter**: Adapter utilizado para preencher uma ListView com **Usuarios**
        * **InfoUsuarioPreference**: Gerencia um arquivo de SharedPreferences. Fornece métodos para acessar duas informações: aceite dos termos e email do usuário.
        
* Slides da aula

