#   API Funcionários Departamentos

> Exemplo de objeto relacional entre as tabelas funcionários e departamentos utilizando Spring Data JPA

## Realização

[![rogeriopontesti dev](https://i.postimg.cc/9MptbzH0/rogeriopontesti.png)](https://github.com/rogeriopontesti)

[![rogeriopontesti no Instagram](https://i.postimg.cc/J75T2knx/1298747-instagram-brand-logo-social-media-icon.png)](https://www.instagram.com/rogeriopontesti)
[![rogeriopontesti no LinkedIn](https://i.postimg.cc/vH8PFZxs/317725-linkedin-social-icon.png)](https://www.linkedin.com/in/rogeriopontesti)
[![rogeriopontesti no Gmail](https://i.postimg.cc/bN6mzf12/7089163-gmail-google-icon.png)](mailto:rogeriopontesti@gmail.com)
[![rogeriopontesti no WhatsApp](https://i.postimg.cc/SKtXsVDd/1783351-chatting-messages-social-media-whatsapp-internet-icon.png)](https://wa.me/5548991877781)

##
### Pré-requisitos

- Lógica de programação (qualquer linguagem)
- Programação orientada a objetos (qualquer linguagem)
- Ferramentas
    - IDE de sua preferência
    - Postman

### Objetivos da Aula

- Reforçar os principais fundamentos de programação
- Aplicar esses conceitos na prática, por meio de exercícios guiados
- Desenvolver um pequeno sistema utilizando ferramentas e práticas adotadas no mercado

### Visão Geral do Sistema

Vamos desenvolver uma pequena API REST para gerenciamento de funcionários e departamentos, com os seguintes casos de uso:

- Listar todos os funcionários cadastrados
- Consultar os dados de um funcionário pelo seu ID
- Cadastrar um novo funcionário no sistema
- Listar todos os funcionários de um departamento

### Inicie configurando o projeto

- [Spring Initializr](https://start.spring.io/)

[![Spring Initializr](https://i.postimg.cc/wv8SzYDd/start-spring-io-funcionarios-departamentos.png)](https://i.postimg.cc/wv8SzYDd/start-spring-io-funcionarios-departamentos.png)

- Diagrama de classes

[![Diagrama de classes](https://i.postimg.cc/tCDtWstM/1.png)](https://i.postimg.cc/tCDtWstM/1.png)

- Tabelas

[![Tabelas](https://i.postimg.cc/zfX8PP9j/Funcionario.png)](https://i.postimg.cc/zfX8PP9j/Funcionario.png)

### Trechos de código para copiar

#### Configurações do banco de dados

```
# Dados de conexão com o banco H2
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

# Configuração do cliente web do banco H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Configuração para mostrar o SQL no console
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

#### Script SQL

```sql
-- =========  DEPARTAMENTOS  =========
INSERT INTO departamentos (id, nome) VALUES ('ae2d767d-fba1-48d7-ad97-a32b45319bcc', 'Superintendência de Transformação Digital');
INSERT INTO departamentos (id, nome) VALUES ('a1138bc4-71df-42b3-bf08-c244670a45e0', 'Superintendência de Tecnologia da Informação');
INSERT INTO departamentos (id, nome) VALUES ('714e607c-1f59-4f43-8219-84ea98022e34', 'Superintendência de Modernização e Gestão');
INSERT INTO departamentos (id, nome) VALUES ('b47d1c5c-4719-43ed-b995-fa84676576b1', 'Superintendência de Planejamento e Parcerias');

-- =========  FUNCIONÁRIOS  =========
INSERT INTO funcionarios (id, nome, qtdd_dependentes, salario, cargo, departamento_id) VALUES ('d33e99b3-fdae-4e83-99f7-2daac7ac99d3', 'Ana Paula Silva', 2, 4500.00, 'Analista de Sistemas', 'ae2d767d-fba1-48d7-ad97-a32b45319bcc');
INSERT INTO funcionarios (id, nome, qtdd_dependentes, salario, cargo, departamento_id) VALUES ('8fa0cba8-38ec-4f73-9e04-5f51255688d7', 'Carlos Alberto Souza', 1, 5200.00, 'Desenvolvedor Backend', 'ae2d767d-fba1-48d7-ad97-a32b45319bcc');
INSERT INTO funcionarios (id, nome, qtdd_dependentes, salario, cargo, departamento_id) VALUES ('2f6acc89-1226-4839-9538-0c70242dae4f', 'Fernanda Lima', 0, 4800.00, 'Analista de Transformação Digital', 'a1138bc4-71df-42b3-bf08-c244670a45e0');
INSERT INTO funcionarios (id, nome, qtdd_dependentes, salario, cargo, departamento_id) VALUES ('da0c2fc7-3bae-4ed1-9fcb-e7c21a43e7ad', 'Marcos Vinícius Oliveira', 3, 6000.00, 'Coordenador de Projetos', 'a1138bc4-71df-42b3-bf08-c244670a45e0');
INSERT INTO funcionarios (id, nome, qtdd_dependentes, salario, cargo, departamento_id) VALUES ('f935ba5c-d33f-4b51-ba68-2945af74e3c2', 'Juliana Andrade', 0, 5500.00, 'Especialista em Redes', 'a1138bc4-71df-42b3-bf08-c244670a45e0');
INSERT INTO funcionarios (id, nome, qtdd_dependentes, salario, cargo, departamento_id) VALUES ('a66ae08e-210e-404f-aca8-12a3898d300a', 'Roberto Santos', 2, 4800.00, 'Administrador de Banco de Dados', 'a1138bc4-71df-42b3-bf08-c244670a45e0');
INSERT INTO funcionarios (id, nome, qtdd_dependentes, salario, cargo, departamento_id) VALUES ('ac9fd7bb-4102-4aff-9dc5-136e03b354b9', 'Larissa Costa', 1, 6200.00, 'Arquiteta de Soluções', 'a1138bc4-71df-42b3-bf08-c244670a45e0');
INSERT INTO funcionarios (id, nome, qtdd_dependentes, salario, cargo, departamento_id) VALUES ('74cff892-f5cb-438f-acaf-82ebcd566fd1', 'Diego Fernandes', 0, 7000.00, 'Gerente de Infraestrutura', 'a1138bc4-71df-42b3-bf08-c244670a45e0');
INSERT INTO funcionarios (id, nome, qtdd_dependentes, salario, cargo, departamento_id) VALUES ('3ce99085-bade-4b13-8b31-70c3319c99ca', 'Lucas Pereira', 2, 4600.00, 'Analista de Processos', 'a1138bc4-71df-42b3-bf08-c244670a45e0');
INSERT INTO funcionarios (id, nome, qtdd_dependentes, salario, cargo, departamento_id) VALUES ('06d36320-70b0-4fd7-a469-7de47ab4111d', 'Mariana Rocha', 1, 5000.00, 'Consultora de Gestão', '714e607c-1f59-4f43-8219-84ea98022e34');
INSERT INTO funcionarios (id, nome, qtdd_dependentes, salario, cargo, departamento_id) VALUES ('311e8efd-50d9-4506-ad7d-1f8bc1f87930', 'Eduardo Gonçalves', 0, 5300.00, 'Coordenador Administrativo', '714e607c-1f59-4f43-8219-84ea98022e34');
INSERT INTO funcionarios (id, nome, qtdd_dependentes, salario, cargo, departamento_id) VALUES ('bdc4f01f-ea07-45e5-b3c2-ea6810e0fcb5', 'Isabela Martins', 4, 5800.00, 'Especialista em Indicadores', '714e607c-1f59-4f43-8219-84ea98022e34');
INSERT INTO funcionarios (id, nome, qtdd_dependentes, salario, cargo, departamento_id) VALUES ('44e121a8-52ad-4502-9e55-a7690fd79a65', 'Patrícia Almeida', 0, 5400.00, 'Analista de Planejamento', 'a1138bc4-71df-42b3-bf08-c244670a45e0');
INSERT INTO funcionarios (id, nome, qtdd_dependentes, salario, cargo, departamento_id) VALUES ('d84f09a3-6b81-45be-888f-42030409d73f', 'Renato Vieira', 2, 6000.00, 'Consultor de Parcerias', 'a1138bc4-71df-42b3-bf08-c244670a45e0');
INSERT INTO funcionarios (id, nome, qtdd_dependentes, salario, cargo, departamento_id) VALUES ('00329b62-c4d1-4c9f-bb4d-39a4ed7eddf5', 'Amanda Nogueira', 1, 6500.00, 'Gerente de Planejamento Estratégico', 'b47d1c5c-4719-43ed-b995-fa84676576b1');
```

### Faça os testes

- Listar todos os funcionários cadastrados

[GET - http://localhost:8080/funcionarios](http://localhost:8080/funcionarios)

- Consultar os dados de um funcionário pelo seu ID

[GET - http://localhost:8080/funcionarios/d33e99b3-fdae-4e83-99f7-2daac7ac99d3](http://localhost:8080/funcionarios/d33e99b3-fdae-4e83-99f7-2daac7ac99d3)

- Cadastrar um novo funcionário no sistema

[POST - http://localhost:8080/funcionarios](http://localhost:8080/funcionarios)

```json

//Request
{
    "nome": "Joaquim da Silveira",
    "salario": 4800.0,
    "qtddDependentes": 2,
    "cargo": "Analista de Sistemas",
    "departamento": {
        "id": "ae2d767d-fba1-48d7-ad97-a32b45319bcc"
    }
}

//Result
{
    "id": "5f241074-8b5e-41f1-88b7-bbe9e32cf54c",
    "nome": "Joaquim da Silveira",
    "salario": 4800.0,
    "qtddDependentes": 2,
    "cargo": "Analista de Sistemas",
    "departamento": {
        "id": "ae2d767d-fba1-48d7-ad97-a32b45319bcc",
        "nome": null
    }
}

```

- Listar todos os funcinários de um departamento

[GET - http://localhost:8080/funcionarios/departamento/ae2d767d-fba1-48d7-ad97-a32b45319bcc](http://localhost:8080/funcionarios/departamento/ae2d767d-fba1-48d7-ad97-a32b45319bcc)


#### Exemplo de saída

Consulta funcionários pelo departamento

[![Tabelas](https://i.postimg.cc/dtCHZbqx/resultado-final.png)](https://i.postimg.cc/dtCHZbqx/resultado-final.png)
