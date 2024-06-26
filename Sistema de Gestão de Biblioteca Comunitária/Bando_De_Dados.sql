CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL,
    papel VARCHAR(20) NOT NULL -- Exemplo de papel: "admin", "usuario"
);

CREATE TABLE emprestimos (
    id SERIAL PRIMARY KEY,
    data_emprestimo DATE NOT NULL,
    data_devolucao DATE,
    usuario_id INT NOT NULL,
    livro_id INT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (livro_id) REFERENCES livros(id)
);

CREATE TABLE categorias (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

-- Criar banco de dados
CREATE DATABASE biblioteca;

-- Conectar ao banco de dados biblioteca
\c biblioteca;

-- Tabela livros
CREATE TABLE livros (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    disponivel BOOLEAN NOT NULL,
    categoria_id INT,
    FOREIGN KEY (categoria_id) REFERENCES categorias(id)
);

-- Tabela usuarios
CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL,
    papel VARCHAR(20) NOT NULL
);

-- Tabela emprestimos
CREATE TABLE emprestimos (
    id SERIAL PRIMARY KEY,
    data_emprestimo DATE NOT NULL,
    data_devolucao DATE,
    usuario_id INT NOT NULL,
    livro_id INT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (livro_id) REFERENCES livros(id)
);

-- Tabela categorias
CREATE TABLE categorias (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);
