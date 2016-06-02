# Aula 05 #

Quinta aula do minicurso "Introdução à plataforma Android", ministrada no dia 08/05/15 para os cursos de Ciência da Computação e Sistemas de Informação da UNIVEM.

### Conteúdo da aula ###

* Criar uma tela que exibe uma lista de **Usuarios**

### Conteúdo do repositório ###

* Projeto criado no Android Studio contendo

    * Resource:
        * **activity_main**: tela com uma lista de usuários e um botão para adicionar um novo usuário à lista
        * **activity_cadastro**: tela para cadastro de um usuário
        * **activity_detalhes**: tela que exibe os detalhes de um usuário
        * **item_list_usuario**: molde para preencher a lista de usuários
    * Activity:
        * **MainActivity**: Possui uma lista de usuários, criada através de um **UsuarioAdapter**. Ao clicar em um item da lista, inicia a **DetalhesActivity**, enviando um **Usuario** como parâmetro. Ao clicar no botão de adicionar, inicia a **CadastroActivity**, esperando um **Usuario** como resultado. 
        * **CadastroActivity**: Armazena todas as informações digitadas em um objeto **Usuario**, e retorna como um resultado
        * **DetalhesActivity**: Recebe um **Usuario** como parâmetro e exibe suas informações
        * **Usuario**: Classe que representa um usuário
        * **UsuarioAdapter**: Adapter utilizado para preencher uma ListView com **Usuarios**
        
* Slides da aula

