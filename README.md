# Spring JPA/H2 DATABASE

Este projeto é um exemplo de aplicação CRUD (Create, Read, Update, Delete) usando Spring Boot, JPA (Java Persistence API) e o banco de dados em memória H2.

## Tecnologias Utilizadas

- Java 11
- Spring Boot 2.5.x
- Spring Data JPA
- H2 Database
- Maven

## Pré-requisitos

- Java Development Kit (JDK) 11 ou superior
- Maven 3.6.x ou superior

## Configuração do Projeto

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/nome-do-repositorio.git
   cd nome-do-repositorio
   ```

2. Compile o projeto com Maven:

   ```bash
   mvn clean install
   ```

## Executando a Aplicação

Você pode executar a aplicação usando o Maven ou diretamente através do seu IDE favorito.

### Executar com Maven

```bash
mvn spring-boot:run
```

### Executar no IDE

1. Importe o projeto como um projeto Maven.
2. Execute a classe principal `com.seu.package.MainApplication`.

## Acessando o Banco de Dados H2

A aplicação está configurada para usar o banco de dados H2 em memória. Você pode acessar o console web do H2 para visualizar e manipular os dados.

- URL do console: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- Usuário: `sa`
- Senha: (deixe em branco)

## Estrutura do Projeto

- `src/main/java`: Contém o código fonte da aplicação.
  - `com.seu.package`: Pacote base do projeto.
    - `domain`: Contém as entidades JPA.
    - `repository`: Contém os repositórios Spring Data JPA.
    - `service`: Contém a lógica de negócios.
    - `controller`: Contém os controladores REST.

- `src/main/resources`: Contém os recursos da aplicação.
  - `application.properties`: Arquivo de configuração da aplicação.

## Endpoints

A aplicação fornece os seguintes endpoints para as operações CRUD:

- `GET /pessoas`: Lista todas as pessoas.
- `GET /pessoas/{id}`: Obtém uma pessoa pelo ID.
- `POST /pessoas`: Cria uma nova pessoa.
- `PUT /pessoas/{id}`: Atualiza uma pessoa existente.
- `DELETE /pessoas/{id}`: Deleta uma pessoa pelo ID.

## Exemplos de Uso

### Criar uma nova pessoa

```bash
curl -X POST http://localhost:8080/pessoas -H "Content-Type: application/json" -d '{"nome": "João", "email": "joao@example.com"}'
```

### Listar todas as pessoas

```bash
curl -X GET http://localhost:8080/pessoas
```

### Obter uma pessoa pelo ID

```bash
curl -X GET http://localhost:8080/pessoas/1
```

### Atualizar uma pessoa

```bash
curl -X PUT http://localhost:8080/pessoas/1 -H "Content-Type: application/json" -d '{"nome": "João Silva", "email": "joao.silva@example.com"}'
```

### Deletar uma pessoa

```bash
curl -X DELETE http://localhost:8080/pessoas/1
```

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request.

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
