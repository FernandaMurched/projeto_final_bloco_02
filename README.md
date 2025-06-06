# 🏪 Projeto Final - Farmácia

---

Este é um sistema **backend** de gerenciamento para uma farmácia, desenvolvido em **Java** com **Spring Boot**. Ele utiliza banco de dados **PostgreSQL (Neon)** e é hospedado na nuvem via **Render**. Este projeto faz parte do projeto final do Bloco 02 do bootcamp **FullStack Java** da Generation Brasil.

O sistema permite o cadastro, atualização, listagem e remoção de produtos e categorias, com autenticação via **JWT**.

---

## 🚀 Funcionalidades

* **Cadastro e login de usuários** com autenticação JWT.
* **Cadastro, listagem, atualização e deleção de produtos**.
* **Gerenciamento de categorias**.
* **Integração com banco de dados PostgreSQL (Neon)**.
* **Segurança com Spring Security**.

---

## 💻 Tecnologias Utilizadas

* **Java 17**
* **Spring Boot**
* **Spring Security**
* **JWT**
* **PostgreSQL (Neon)**
* **Maven**
* **Render** (para deploy)

---

## 🛠️ Como Rodar Localmente

Para rodar este projeto em sua máquina local, siga os passos abaixo:

### Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas:

* **Java 17 Development Kit (JDK)**
* **Maven** (gerenciador de dependências)
* **Git**
* Um cliente **PostgreSQL** (ou acesso a um banco de dados Neon)
* Uma IDE como **IntelliJ IDEA** ou **VS Code** com suporte a Spring Boot (recomendado)

### Configuração e Execução

1.  **Clone o repositório**:
    ```bash
    git clone [https://github.com/FernandaMurched/projeto_final_bloco_02.git](https://github.com/FernandaMurched/projeto_final_bloco_02.git)
    cd projeto_final_bloco_02
    ```

2.  **Configuração do Banco de Dados PostgreSQL**:
    * Este projeto utiliza **PostgreSQL**. Você pode configurar um banco de dados localmente ou usar uma conta **Neon** (que é a utilizada no deploy).
    * Crie um banco de dados PostgreSQL para o projeto.
    * **Variáveis de Ambiente**: O projeto espera a URL de conexão do banco de dados na variável de ambiente `DATABASE_URL`. Crie um arquivo `.env` na raiz do projeto (ou configure diretamente em sua IDE/sistema operacional) com a seguinte linha:
        ```
        DATABASE_URL=jdbc:postgresql://<seu_host_bd>:<sua_porta_bd>/<seu_nome_bd>?user=<seu_usuario_bd>&password=<sua_senha_bd>
        ```
        *Substitua os `<>` pelos dados do seu banco de dados.* Se estiver usando Neon, copie a `Connection String` do seu projeto Neon e a utilize aqui.

3.  **Execute a Aplicação**:
    * Abra o projeto em sua IDE (IntelliJ IDEA, VS Code, etc.).
    * As dependências do Maven serão baixadas automaticamente.
    * Rode a classe principal `com.projetofarmacia.ProjetoFinalFarmaciaApplication.java` como uma aplicação Spring Boot.
    * Alternativamente, você pode executar via linha de comando (na raiz do projeto):
        ```bash
        mvn spring-boot:run
        ```

4.  **Acesse a API**:
    * Uma vez que a aplicação esteja rodando, a API estará acessível em `http://localhost:8080`.
    * A documentação interativa do Swagger estará disponível em: `http://localhost:8080/swagger-ui.html`.

---

## 💡 Como Usar a API

A API utiliza autenticação com **JWT**. Após o login, é necessário adicionar o token no header `Authorization` para acessar rotas protegidas.

1.  **Cadastre um usuário**:
    * **Requisição**: `POST /usuarios/cadastrar`
    * **Exemplo de Corpo da Requisição**:
        ```json
        {
            "usuario": "seuemail@example.com",
            "senha": "suasenhaforte"
        }
        ```

2.  **Faça login**:
    * **Requisição**: `POST /usuarios/logar`
    * **Exemplo de Corpo da Requisição**:
        ```json
        {
            "usuario": "root@email.com",
            "senha": "rootroot"
        }
        ```
    * **Resposta**: Você receberá um token JWT.

3.  **Use o token**: Copie o token retornado e use-o em todas as requisições protegidas no header:
    ```
    Authorization: Bearer SEU_TOKEN_AQUI
    ```

### Exemplos de Requisições

#### `POST /produtos` - Criar um Novo Produto

```json
{
    "nome": "Shampoo Hidratante",
    "preco": 19.90,
    "quantidadeEstoque": 120,
    "foto": "[https://example.com/shampoo.jpg](https://example.com/shampoo.jpg)",
    "categoria": {
        "id": 3
    }
}

📁 Estrutura das Rotas da API
/usuarios
POST /cadastrar
POST /logar
/produtos
GET /todos
POST /novo
PUT /atualizar
DELETE /{id}
/categorias
GET /todas
POST /nova
PUT /atualizar
DELETE /{id}
📚 Documentação da API
A documentação completa e interativa da API, gerada automaticamente com Swagger/OpenAPI, pode ser acessada através do link abaixo:

🔗 Acessar Documentação da API (Swagger UI)

Nela, você encontrará detalhes sobre todos os endpoints, modelos de dados (DTOs), parâmetros de requisição, exemplos de respostas e poderá testar a API diretamente pelo navegador.

👩‍💻 Autora
Fernanda Murched
Desenvolvedora Java FullStack

🔗 [LinkedIn](https://www.linkedin.com/in/fernandamurched/)