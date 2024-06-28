<!-- TOC -->
* [SQL Validator](#sql-validator)
    * [Funcionalidades](#funcionalidades)
    * [Exemplo](#exemplo)
        * [Caso a consulta retorne um SQL válido](#caso-a-consulta-retorne-um-sql-válido)
        * [Caso a consulta retorne um SQL inválido](#caso-a-consulta-retorne-um-sql-inválido)
    * [Futuras Features](#futuras-features)
<!-- TOC -->

# SQL Validator
Este projeto tem como objetivo receber um arquivo em formato SQL e realizar a verificação de erros nas palavras-chave presentes no mesmo. A verificação deve identificar e retornar os erros encontrados, proporcionando uma análise clara e compreensível para auxiliar na correção e otimização dos scripts SQL.

## Funcionalidades
- Receber um SQL através dos parâmetros da requisição
- Analisar os erros
- Retornar os erros de forma legível

## Exemplo
Demonstração de como funciona a requisição e os resultados:

Atualmente, os parâmetros são apenas uma string contendo um SQL.

### Caso a consulta retorne um SQL válido
![SQL Válido](https://i.imgur.com/wV8fFVE.png)

### Caso a consulta retorne um SQL inválido
![SQL Inválido](https://i.imgur.com/BEuZ2E5.png)

## Futuras Features
- [ ] Receber um arquivo SQL diretamente
- [ ] Melhorar a legibilidade dos erros retornados
