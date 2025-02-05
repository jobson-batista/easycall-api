# Easy Call Rest API 🌍

_[🇺🇸 English Version](#easy-callrest-api-en-)_

_[🇧🇷 Versão em Português](#easy-callrest-api-pt-br-)_
# Easy Call Rest API (PT-BR) 🇧🇷

A EasyCall Rest API permite o gerenciamento de contatos, incluindo cadastro, busca por número de celular, atualização, marcação como favorito e exclusão. Esta API Rest possui as seguintes funcionalidades.
* Cadastrar Contato
* Buscar Contatos Por Número de Celular
* Atualizar de Contatos
* Marcar Contatos como Favoritos
* Excluir Contatos

## 🛠️ Construído com

* [Java 21](https://www.oracle.com/br/java/technologies/downloads/#java21)
* [Gradle 8.10](https://gradle.org/releases/) - Gerente de Dependência
* [JUnit 5](https://junit.org/junit5/) - Framework de testes automatizados
* [Lombok](https://projectlombok.org/) - Ferramenta para diminuir a verbosidade das classes

## 🚀 Começando

### 📋 Pré-requisitos

Para rodar o projeto você precisa ter:

* [JDK 21](https://www.oracle.com/br/java/technologies/downloads/#java21)
* [PostgresSQL 14+](https://www.postgresql.org/) - O Banco de dados deve está rodando (em nuvem ou localmente).

### 🔧 Instalação

1. Clone o repositório em sua máquina local.
```bash
git clone git@github.com:jobson-batista/easycall-api.git
```
2. Entre no diretório raiz.
```bash
cd easycall-api/
```
3. Rodar as tasks ```clean``` e ```build``` para limpar arquivos de outras execuções e construir a aplicação, respectivamente.
```bash
./gradlew clean build --refresh-dependencies
```
### ⚙️ Execução

1. Defina as variáveis de ambiente para acessar o banco de dados no seu Sistema Operacional ou na sua IDE.
* No Linux ou Mac OS 
```bash
export DATABASE_URL=jdbc:postgresql://{host}:{port}/{database}
export DATABASE_USER={user}
export DATABASE_PASSWORD={password}
```
* No Windows (CMD ou PowerShell)
```bash
set DATABASE_URL=jdbc:postgresql://{host}:{port}/{database}
set DATABASE_USER={user}
set DATABASE_PASSWORD={password}
```
3. Rodar a task ```bootRun```
```bash
./gradlew bootRun
```
## ⚙️ Executando os testes
Para executar os testes automatizados é bem simples, basta rodar a task de teste.
```bash 
./gradlew clean test
```

## 🤝 Contribuindo

Contribuições são bem-vindas! Se você deseja contribuir com melhorias para a Easy Call Rest API, siga os passos abaixo:

1. **Faça um Fork** deste repositório.
2. **Crie uma branch** para sua feature ou correção:
```bash
git checkout -b minha-feature
```
3. **Implemente suas alterações** seguindo as boas práticas de desenvolvimento.
4. **Execute os testes** para garantir que tudo está funcionando corretamente:
```bash
./gradlew test
```
5. **Faça commit das suas alterações**
6. **Envie suas alterações para o seu repositório remoto**
7. **Crie um Pull Request** explicando suas alterações.

#### ☕️ Não esqueça de tomar café 

# Easy Call Rest API (EN) 🇺🇸

The **EasyCall Rest API** allows contact management, including registration, search by cell phone number, updating, marking as favorite, and deletion. This REST API provides the following functionalities:
* Register Contact
* Search Contacts by Cell Phone Number
* Update Contacts
* Mark Contacts as Favorites
* Delete Contacts

## 🛠️ Built with

* [Java 21](https://www.oracle.com/java/technologies/downloads/#java21)
* [Gradle 8.10](https://gradle.org/releases/) - Dependency Management Tool
* [JUnit 5](https://junit.org/junit5/) - Automated Testing Framework
* [Lombok](https://projectlombok.org/) - Tool to reduce class verbosity

## 🚀 Getting Started

### 📋 Prerequisites

To run the project, you need to have:

* [JDK 21](https://www.oracle.com/java/technologies/downloads/#java21)
* [PostgreSQL 14+](https://www.postgresql.org/) - The database must be running (either locally or in the cloud).

### 🔧 Installation

1. Clone the repository to your local machine:
```bash
git clone git@github.com:jobson-batista/easycall-api.git

```

2.  Navigate to the root directory:

```bash
cd easycall-api/

```

3.  Run the `clean` and `build` tasks to clear previous build files and compile the application:

```bash
./gradlew clean build --refresh-dependencies

```

### ⚙️ Running the Application

1.  Set up the environment variables for database access on your OS or IDE.

-   On Linux or Mac OS:

```bash
export DATABASE_URL=jdbc:postgresql://{host}:{port}/{database}
export DATABASE_USER={user}
export DATABASE_PASSWORD={password}

```

-   On Windows (CMD or PowerShell):

```bash
set DATABASE_URL=jdbc:postgresql://{host}:{port}/{database}
set DATABASE_USER={user}
set DATABASE_PASSWORD={password}

```

3.  Run the `bootRun` task:

```bash
./gradlew bootRun

```

## ⚙️ Running Tests

To execute automated tests, simply run the test task:

```bash
./gradlew clean test

```

## 🤝 Contributing

Contributions are welcome! If you want to contribute improvements to the Easy Call Rest API, follow these steps:

1.  **Fork** this repository.
2.  **Create a branch** for your feature or fix:

```bash
git checkout -b my-feature

```

3.  **Implement your changes** following development best practices.
4.  **Run the tests** to ensure everything is working correctly:

```bash
./gradlew test

```

5.  **Commit your changes**
6.  **Push your changes to your remote repository**
7.  **Create a Pull Request** explaining your changes.

#### ☕️ Don't forget to grab a coffee!
