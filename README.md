# PAC-UFG
Protótipo da Arquitetura de Software do PAC UFG

# Objetivo

- O objetivo desse projeto é obter uma validação da arquitetura escolhida e da decisão das tecnologias (Spring Boot + TymeLeaf + JPA + MySql).

# Resultado esperado

- O resultado será um protótipo simples de um caso de uso (PACOTE), do qual deverá ser suficiente para executar os aspectos mais importantes
do negócio e das tecnologias envolvidas. Além disso servirá para mapear as dificuldades iniciais e nível dos envolvidos nesse projeto. 

## CONFIGURAÇÃO DO PROJETO

### Padrões de projeto utilizados
  
  - MVC
  - Repository
  
### Organização do projeto

```
src
  |- controllers[+] -> Contém as classes de comunicação entre View e Repository
  |- entities[+] -> Contém as entidades do modelo de domínio.        
  |- PacApplication.java -> Responsável por executar a aplicação.
  |-resources
            |- static
            |- templates -> Contém os arquivos de View (HTML) utilizados com o framework Tymeleaf
```

### Configuração do MySql:

IP: localhost:3306
BASE_DE_DADOS = pac_ufg
USERNAME: user //credenciais do seu banco de dados
PASSWORD: pass //credenciais do seu banco de dados

```
spring.jpa.hibernate.ddl-auto=create
spring.datasource.url=jdbc:mysql://IP/BASE_DE_DADOS
spring.datasource.username=USERNAME
spring.datasource.password=PASSWORD

```

Copie o bloco acima e substitua os valores com os correspondentes para dentro do arquivo:

src > main > resources > application.properties

## Design das telas

[Mapa de navegação ](https://docs.google.com/document/d/1YIXHwwTEfLWJOpEIyHM07hjGyvoxynlbnA5JbFSXcB4/edit)

## AJUDA COM SPRING BOOT + TYMELEAF

[Tutorial 1 - Exemplo de formulário com tymeleaf](https://spring.io/guides/gs/handling-form-submission/)

[Tutorial 2 - Exemplo de uso do JPA + MySql](https://spring.io/guides/gs/accessing-data-mysql/)





