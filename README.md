
# DummyJSON Client - Java 17 e Spring Boot 3.2.5

## Descrição do Projeto

Este projeto é um microsserviço Java que interage com a API pública [DummyJSON](https://dummyjson.com/docs/products) para realizar operações de busca de produtos. O projeto foi desenvolvido usando Java 17 e Spring Boot 3.2.5.

## Funcionalidades

- **Consulta de Produtos**: Realiza chamadas para a API do DummyJSON para buscar informações sobre produtos.
- **Integração com `WebFlux`**: Utiliza `WebClient` para realizar chamadas HTTP.
- **Validação de Dados**: Validação de dados de entrada usando Bean Validation (`jakarta.validation`).
- **Gestão de Dependências**: Configurado para utilizar @Autoweird.
- **Testes Unitários**: Inclui testes unitários desenvolvidos com JUnit 5 e Mockito.

## Estrutura do Projeto

```bash
dummyjson-client
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.dummyjsonclient
│   │   │       ├── DummyJsonClientApplication.java
│   │   │       ├── config
│   │   │       │   └── RestTemplateConfig.java
│   │   │       ├── controller
│   │   │       │   └── ProductController.java
│   │   │       ├── dto
│   │   │       │   └── Product.java
│   │   │       ├── service
│   │   │       │   └── ProductService.java
│   │   └── resources
│   │       └── application.properties
│   │       └── application-dev.properties
│   │       └── application-prod.properties
│   └── test
│       ├── java
│       │   └── com.example.dummyjsonclient
│       │       ├── config
│       │       │   └── RestTemplateConfigTest.java
│       │       └── controller
│       │       │   └── ProductControllerTest.java
│       │       ├── dto
│       │       │   └── ProductTest.java
│       │       └── service
│       │           └── ProductServiceTest.java
│       └── resources
└── .gitignore
└── docker-compose.yaml
└── Dockerfile
└── Dockerfile.dev
└── pom.xml
└── README.md
```

## Passos para Executar o Projeto

### Pré-requisitos

- **Java 17**
- **Maven 3.9.3**

### Executar a Aplicação

1. Clone o repositório:

    ```bash
    git clone https://github.com/eliascmurat/code-challenge-migration/tree/feature-atualiza-versao
    cd dummyjson-client
    ```

2. Compile e execute o projeto localmente:

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

### Compile e execute o projeto com Docker

1. Construir a imagem Docker e executar a aplicação:

    ```bash  
    docker-compose up --build
    ```

### Executar Testes

1. Para executar os testes unitários:

    ```bash
    mvn clean test
    ```

### Verificar a saúde do serviço

1. O endpoint de saúde pode ser acessado em::

    ```
    http://localhost:8080/actuator/health
    ```
