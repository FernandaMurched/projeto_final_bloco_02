
# 🏪 Projeto Final - Farmácia


Este é um sistema backend de gerenciamento para uma farmácia, desenvolvido em Java com Spring Boot,usando banco de dados PostgreSQL (Neon) e hospedagem na nuvem via Render como parte do projeto final do Bloco 02 do bootcamp **FullStack Java** da Generation Brasil.

O sistema permite o cadastro, atualização, listagem e remoção de produtos e categorias, com autenticação via JWT.


# 📚 Documentação da API - Farmácia

Esta é a documentação da API desenvolvida com Spring Boot para o gerenciamento de uma farmácia.

---

## 🔐 Autenticação

A API utiliza autenticação com **JWT**. Após o login, é necessário adicionar o token no header `Authorization` para acessar rotas protegidas.

## 🔑 Login

`POST /usuarios/logar`

```json
{
  "usuario": "root@email.com",
  "senha": "rootroot"
}


Recebe dois números e retorna a sua soma.


🚀 Funcionalidades

- Cadastro e login de usuários com autenticação JWT
- Cadastro, listagem, atualização e deleção de produtos
- Gerenciamento de categorias
- Integração com banco de dados PostgreSQL (Neon)
- Segurança com Spring Security



💻 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Security
- JWT
- PostgreSQL (Neon)
- Maven
- Render (deploy)
🔧 Como usar a API

1. Cadastre um usuário: `POST /usuarios/cadastrar`
2. Faça login: `POST /usuarios/logar`
3. Copie o token retornado
4. Use o token em todas as requisições protegidas no header:

Authorization: Bearer SEU_TOKEN_AQUI

Exemplos de requisições

POST /produtos
{
  "nome": "Shampoo Hidratante",
  "preco": 19.90,
  "quantidadeEstoque": 120,
  "foto": "https://example.com/shampoo.jpg",
  "categoria": {
    "id": 3
  }
}

📁 Estrutura da API

- /usuarios
  - /cadastrar
  - /logar

- /produtos
  - GET /todos
  - POST /novo
  - PUT /atualizar
  - DELETE /{id}

- /categorias
  - GET /todas
  - POST /nova
  - PUT /atualizar
  - DELETE /{id}

👩‍💻 Autora
**Fernanda Murched**  
Desenvolvedora Java FullStack

🔗 [LinkedIn](https://www.linkedin.com/in/fernandamurched/)
