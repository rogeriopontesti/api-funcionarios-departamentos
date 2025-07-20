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
-- Inserção dos departamentos com UUID
INSERT INTO departamentos (id, nome) VALUES
('dpt-uuid-001', 'Superintendência de Transformação Digital'),
('dpt-uuid-002', 'Superintendência de Tecnologia da Informação'),
('dpt-uuid-003', 'Superintendência de Modernização e Gestão'),
('dpt-uuid-004', 'Superintendência de Planejamento e Parcerias');

-- Inserção dos funcionários com UUID e novo campo qtdd_dependentes
INSERT INTO funcionarios (id, nome, qtdd_dependentes, salario, cargo, departamento_id) VALUES
('func-uuid-001', 'Ana Paula Silva', 2, 4500.00, 'Analista de Sistemas', 'dpt-uuid-001'),
('func-uuid-002', 'Carlos Alberto Souza', 1, 5200.00, 'Desenvolvedor Backend', 'dpt-uuid-001'),
('func-uuid-003', 'Fernanda Lima', 0, 4800.00, 'Analista de Transformação Digital', 'dpt-uuid-002'),
('func-uuid-004', 'Marcos Vinícius Oliveira', 3, 6000.00, 'Coordenador de Projetos', 'dpt-uuid-002'),

('func-uuid-005', 'Juliana Andrade', 0, 5500.00, 'Especialista em Redes', 'dpt-uuid-002'),
('func-uuid-006', 'Roberto Santos', 2, 4800.00, 'Administrador de Banco de Dados', 'dpt-uuid-002'),
('func-uuid-007', 'Larissa Costa', 1, 6200.00, 'Arquiteta de Soluções', 'dpt-uuid-002'),
('func-uuid-008', 'Diego Fernandes', 0, 7000.00, 'Gerente de Infraestrutura', 'dpt-uuid-002'),

('func-uuid-009', 'Lucas Pereira', 2, 4600.00, 'Analista de Processos', 'dpt-uuid-002'),
('func-uuid-010', 'Mariana Rocha', 1, 5000.00, 'Consultora de Gestão', 'dpt-uuid-003'),
('func-uuid-011', 'Eduardo Gonçalves', 0, 5300.00, 'Coordenador Administrativo', 'dpt-uuid-003'),
('func-uuid-012', 'Isabela Martins', 4, 5800.00, 'Especialista em Indicadores', 'dpt-uuid-003'),

('func-uuid-013', 'Patrícia Almeida', 0, 5400.00, 'Analista de Planejamento', 'dpt-uuid-002'),
('func-uuid-014', 'Renato Vieira', 2, 6000.00, 'Consultor de Parcerias', 'dpt-uuid-002'),
('func-uuid-015', 'Amanda Nogueira', 1, 6500.00, 'Gerente de Planejamento Estratégico', 'dpt-uuid-004');

```
