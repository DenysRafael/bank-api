# 🏦 Bank API

REST API de gerenciamento bancário desenvolvida em Java com Spring Boot.

🔗 **API online:** https://bank-api-z4d4.onrender.com/api/accounts

## 💻 Tecnologias

- Java 21
- Spring Boot 3.2.5
- Spring Data JPA
- PostgreSQL
- Maven
- Deploy: Render (Docker)

## ⚙️ Funcionalidades

- Cadastro de contas bancárias (corrente e poupança)
- Listagem de contas ativas
- Depósito e saque
- Soft delete (desativação de conta)
- Interface web integrada

## 🚀 Como rodar localmente

1. Clone o repositório
git clone https://github.com/DenysRafael/bank-api.git

2. Tenha um PostgreSQL rodando localmente (ou use o `docker-compose.yml` incluído no projeto: `docker-compose up -d`)

3. Crie um banco `bankdb` com usuário `bankuser` e senha `bankpass` (ou ajuste `src/main/resources/application.properties` com suas próprias credenciais)

4. Abra o projeto no IntelliJ IDEA e aguarde o Maven baixar as dependências

5. Rode `BankApiApplication.java`

6. Abra `frontend/index.html` no navegador, ou acesse a API diretamente em `http://localhost:8080/api/accounts`

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

O projeto usa PostgreSQL tanto em desenvolvimento quanto em produção.

- **Local:** configurado via `application.properties`, com fallback para variáveis de ambiente (`SPRING_DATASOURCE_URL`, `SPRING_DATASOURCE_USERNAME`, `SPRING_DATASOURCE_PASSWORD`)
- **Produção:** PostgreSQL hospedado no Render, configurado através dessas mesmas variáveis de ambiente no serviço

---

Desenvolvido por **Denys Santos** — https://www.linkedin.com/in/denyssantos-
