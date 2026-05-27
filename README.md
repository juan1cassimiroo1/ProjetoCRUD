# RPG Inventory Manager CLI

## Descrição do Projeto
Esta aplicação é um sistema de gerenciamento de inventário de um jogos de RPG, executado inteiramente via linha de comando (CLI). O software permite o controle completo (CRUD) de itens colecionáveis e equipamentos divididos em categorias distintas.

## Funcionalidades Aplicadas
* **CRUD Completo em Memória:** Permite Criar, Listar, Atualizar e Deletar itens dinamicamente.
* **Uso de Orientação a Objetos:** 
  * **Herança e Polimorfismo:** A classe abstrata mãe `Item` estende suas características para as classes filhas especializadas `Arma` e `Pocao`. O polimorfismo é aplicado na sobrescrita do método `toString()`.
  * **Encapsulamento:** Todos os atributos possuem modificadores de acesso `private` e são manipulados exclusivamente via métodos *getters* e *setters*.
* **Validação de Dados:** Mecanismos que impedem o travamento da aplicação (`Exception Handling`) caso o usuário digite letras em campos numéricos ou insira valores vazios/negativos.

## Como Executar o Projeto

Certifique-se de ter o Java Development Kit (JDK) instalado em sua máquina.

1. Abra o terminal (Prompt de Comando ou Bash) e navegue até a pasta raiz onde a pasta `src` está localizada.