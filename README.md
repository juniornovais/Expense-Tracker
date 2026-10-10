# Expense Tracker API

API REST desenvolvida em Spring Boot para gerenciamento de despesas pessoais. Permite o registro, atualização, remoção, visualização e exportação de despesas, além de controle de resumos mensais.

## Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Spring Web
- Spring Boot Validation

## Funcionalidades

- Adicionar nova despesa (com descrição, valor e data).
- Atualizar dados de uma despesa existente.
- Excluir uma despesa.
- Listar todas as despesas cadastradas.
- Visualizar resumo geral de todas as despesas.
- Visualizar resumo de despesas filtrado por mês específico.

## Como Executar o Projeto

1. Certifique-se de ter o **Java 21** e o **Maven** instalados em sua máquina.
2. Clone o repositório ou abra a pasta raiz do projeto no seu terminal.
3. Execute o comando Maven para iniciar a aplicação:
   ```bash
   mvn spring-boot:run
