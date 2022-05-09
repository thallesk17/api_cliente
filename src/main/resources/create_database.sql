-- Apagar o banco de dados
drop database banco;
-- Criar o banco de dados
create database banco;
-- Atribuir os privilégios de acesso aos objetos do banco
-- para o usuário root
GRANT ALL PRIVILEGES ON banco.* TO 'root' @'localhost';
-- Acesar o banco de dados: banco
USE banco;
-- Criar a tabela: usuario
CREATE TABLE cliente(
    id int AUTO_INCREMENT,
    cpf varchar(20) NOT NULL,
    nome varchar(50) NOT NULL,
    sexo char NOT NULL,
    data_nascimento date NOT NULL,
    endereco_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (endereco_id) REFERENCES endereco(id)
);

CREATE TABLE endereco(
    id int,
    cep varchar(20),
    rua varchar(30),
    bairro varchar(20),
    numero int,
    cidade varchar(20),
    uf varchar(2),
    PRIMARY KEY (id)
)

ALTER TABLE cliente ADD CONSTRAINT id_endereco_id
FOREIGN KEY(endereco_id) REFERENCES endereco (id);


