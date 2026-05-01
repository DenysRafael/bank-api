# 🏦 Bank API

REST API de gerenciamento bancário desenvolvida em Java com Spring Boot.

## 💻 Tecnologias

- Java 21
- Spring Boot 3.2.5
- Spring Data JPA
- Banco H2 (em memória)
- Maven

## ⚙️ Funcionalidades

- Cadastro de contas bancárias (corrente e poupança)
- Listagem de contas ativas
- Depósito e saque
- Soft delete (desativação de conta)
- Interface web integrada

## 🚀 Como rodar

1. Clone o repositório
git clone https://github.com/DenysRafael/bank-api.git

2. Abra no IntelliJ IDEA

3. Aguarde o Maven baixar as dependências

4. Rode o BankApiApplication.java

5. Abra frontend/index.html no navegador

A API estará disponível em [http://localhost:8080/api/accounts](https://bank-api-production-dedb.up.railway.app)

## 📋 Endpoints

| Método | URL | Descrição |
|--------|-----|-----------|
| GET | /api/accounts | Lista contas ativas |
| GET | /api/accounts/{id} | Busca conta por ID |
| POST | /api/accounts | Cria nova conta |
| PUT | /api/accounts/{id} | Atualiza conta |
| DELETE | /api/accounts/{id} | Desativa conta |
| POST | /api/accounts/{id}/deposit | Realiza depósito |
| POST | /api/accounts/{id}/withdraw | Realiza saque |

## 🗄️ Banco de Dados

Acesse o console H2 em http://localhost:8080/h2-console

- JDBC URL: jdbc:h2:mem:bankdb
- User: sa
- Password: (vazio)

---

Desenvolvido por **Denys Santos** — https://www.linkedin.com/in/denyssantos-
