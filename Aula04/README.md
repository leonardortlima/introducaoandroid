# Aula 04 #

Quarta aula do minicurso "Introdução à plataforma Android", ministrada no dia 24/04/15 para os cursos de Ciência da Computação e Sistemas de Informação da UNIVEM.

### Conteúdo da aula ###

* Trocar informações entre activities através de **Itents**

### Conteúdo do repositório ###

* Projeto criado no Android Studio contendo

    * Resource:
        * **activity_main**: tela que redireciona o usuário para a tela de cadastro ou de detalhes
        * **activity_cadastro**: tela para cadastro de um usuário
        * **activity_detalhes**: tela que exibe os detalhes de um usuário
    * Activity:
        * **MainActivity**: Inicia a **CadastroActivity**, esperando um **Usuario** como resultado ou a **DetalhesActivity**, enviando um **Usuario** como parâmetro
        * **CadastroActivity**: Armazena todas as informações digitadas em um objeto **Usuario**, e retorna como um resultado
        * **DetalhesActivity**: Recebe um **Usuario** como parâmetro e exibe suas informações
        * **Usuario**: Classe que representa um usuário
        
* Slides da aula

