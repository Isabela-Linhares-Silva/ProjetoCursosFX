CREATE DATABASE projeto;
USE projeto;

CREATE TABLE aluno (
        id INT PRIMARY KEY,
        nome VARCHAR(100),
        email VARCHAR(100)
);

CREATE TABLE professor (
       id INT PRIMARY KEY,
       nome VARCHAR(100),
       especialidade VARCHAR(100)
);

CREATE TABLE curso (
       id INT PRIMARY KEY,
       nome VARCHAR(100),
       cargaHoraria INT,
       preco DOUBLE,
       professor_id INT,
       FOREIGN KEY (professor_id) REFERENCES professor(id)
);

CREATE TABLE matricula (
       id INT PRIMARY KEY,
       aluno_id INT,
       curso_id INT,
       FOREIGN KEY (aluno_id) REFERENCES aluno(id),
       FOREIGN KEY (curso_id) REFERENCES curso(id),
       data DATE,
       status VARCHAR(50),
       valor DOUBLE,
       data_pagamento DATE,
       status_pagamento VARCHAR(50),
);