# Aula 07 #

Sétima aula do minicurso "Introdução à plataforma Android", ministrada no dia 22/05/15 para os cursos de Ciência da Computação e Sistemas de Informação da UNIVEM.

### Conteúdo da aula ###

* Utilizar banco de dados SQLite para armazenar os usuários que preencherão a lista

### Conteúdo do repositório ###

* Projeto criado no Android Studio contendo

    * Resource:
        * **activity_main**: tela com os termos de uso da aplicação e uma caixa de texto para cadastro de email do usuário
        * **activity_list_usuario**: tela com uma lista de usuários e um botão para adicionar um novo usuário à lista
        * **activity_cadastro**: tela para cadastro de um usuário
        * **activity_detalhes**: tela que exibe os detalhes de um usuário e permitindo editá-lo ou excluí-lo
        * **item_list_usuario**: molde para preencher a lista de usuários
    * Activity:
        * **MainActivity**: Tela exibida somente uma vez (caso o usuário aceite os termos). Armazena em um SharedPreferences o aceite dos termos de uso e o email do usuário.
        * **ListUsuarioActivity**: Possui exibe uma lista de usuários salvos no banco. A lista é preenchida por meio de um **UsuarioAdapter**. Ao clicar em um item da lista, inicia a **DetalhesActivity**, enviando um **Usuario** como parâmetro. Ao clicar no botão de adicionar, inicia a **CadastroActivity**, esperando um **Usuario** como resultado.
        * **CadastroActivity**: Armazena todas as informações digitadas em um objeto **Usuario**, salva no banco, e retorna como um resultado da Activity
        * **DetalhesActivity**: Recebe um **Usuario** como parâmetro e exibe suas informações, permitindo editá-las ou excluir um Usuario por completo
        * **Usuario**: Classe que representa um usuário.
        * **UsuarioDAO**: Classe que gerencia a interacao de um objeto Usuario com o banco. Fornece metodos para salvar, alterar, apagar e listar usuarios.
        * **UserDbHelper**: Classe com métodos que gerenciam o "ciclo de vida" do banco.
        * **UsuarioAdapter**: Adapter utilizado para preencher uma ListView com **Usuarios**
        * **InfoUsuarioPreference**: Gerencia um arquivo de SharedPreferences. Fornece métodos para acessar duas informações: aceite dos termos e email do usuário.
        
* Slides da aula
