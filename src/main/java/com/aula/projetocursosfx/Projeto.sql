CREATE DATABASE projeto;
USE projeto;

CREATE TABLE aluno (
        id INT AUTO_INCREMENT PRIMARY KEY,
        nome VARCHAR(100),
        email VARCHAR(100)
);

CREATE TABLE professor (
       id INT AUTO_INCREMENT PRIMARY KEY,
       nome VARCHAR(100),
       especialidade VARCHAR(100)
);

CREATE TABLE curso (
       id INT AUTO_INCREMENT PRIMARY KEY,
       nome VARCHAR(100),
       carga_horaria INT,
       preco DOUBLE,
       professor_id INT,
       FOREIGN KEY (professor_id) REFERENCES professor(id)
);

CREATE TABLE matricula (
       id INT AUTO_INCREMENT PRIMARY KEY,
       aluno_id INT,
       curso_id INT,
       FOREIGN KEY (aluno_id) REFERENCES aluno(id),
       FOREIGN KEY (curso_id) REFERENCES curso(id),
       status VARCHAR(50),
       valor DOUBLE,
       data_pagamento DATE,
       status_pagamento VARCHAR(50)
);

CREATE TABLE usuario(
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL
);

INSERT INTO usuario(email, senha)
VALUES ('admin', '123');