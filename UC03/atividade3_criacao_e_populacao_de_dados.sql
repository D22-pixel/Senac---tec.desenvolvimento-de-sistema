-- Criando o banco de dados
CREATE DATABASE PlataformaJogos;
USE PlataformaJogos;

-- Tabela Usuário
CREATE TABLE Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    senha VARCHAR(100),
    data_cadastro DATE
);

-- Tabela Desenvolvedora
CREATE TABLE Desenvolvedora (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    pais VARCHAR(50),
    ano_fundacao INT
);

-- Tabela Jogo
CREATE TABLE Jogo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100),
    data_lancamento DATE,
    preco DECIMAL(10, 2),
    id_desenvolvedora INT,
    FOREIGN KEY (id_desenvolvedora) REFERENCES Desenvolvedora(id)
);

-- Tabela Categoria
CREATE TABLE Categoria (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50)
);

-- Tabela para relacionamento N:N entre Jogos e Categorias
CREATE TABLE JogoCategoria (
    id_jogo INT,
    id_categoria INT,
    PRIMARY KEY (id_jogo, id_categoria),
    FOREIGN KEY (id_jogo) REFERENCES Jogo(id),
    FOREIGN KEY (id_categoria) REFERENCES Categoria(id)
);

-- Tabela para relacionamento N:N entre Usuário e Jogo (Biblioteca)
CREATE TABLE Biblioteca (
    id_usuario INT,
    id_jogo INT,
    data_aquisicao DATE,
    PRIMARY KEY (id_usuario, id_jogo),
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id),
    FOREIGN KEY (id_jogo) REFERENCES Jogo(id)
);

-- Inserindo dados na tabela Usuario
INSERT INTO Usuario (nome, email, senha, data_cadastro) VALUES
('Carlos Silva', 'carlos.silva@gmail.com', 'senha123', '2023-01-10'),
('Ana Costa', 'ana.costa@gmail.com', 'senha123', '2023-02-15'),
('Marcos Dias', 'marcos.dias@gmail.com', 'senha123', '2023-03-20'),
('Luciana Lima', 'luciana.lima@gmail.com', 'senha123', '2023-04-22'),
('João Pedro', 'joao.pedro@gmail.com', 'senha123', '2023-05-30'),
('Fernanda Souza', 'fernanda.souza@gmail.com', 'senha123', '2023-06-05'),
('Bruno Almeida', 'bruno.almeida@gmail.com', 'senha123', '2023-07-07'),
('Camila Rocha', 'camila.rocha@gmail.com', 'senha123', '2023-08-11'),
('Pedro Henrique', 'pedro.henrique@gmail.com', 'senha123', '2023-09-14'),
('Roberta Melo', 'roberta.melo@gmail.com', 'senha123', '2023-10-18');

-- Inserindo dados na tabela Desenvolvedora
INSERT INTO Desenvolvedora (nome, pais, ano_fundacao) VALUES
('Valve Corporation', 'EUA', 1996),
('Epic Games', 'EUA', 1991),
('CD Projekt Red', 'Polônia', 2002),
('Rockstar Games', 'EUA', 1998),
('Ubisoft', 'França', 1986),
('Square Enix', 'Japão', 2003),
('Electronic Arts', 'EUA', 1982),
('FromSoftware', 'Japão', 1986),
('Bethesda', 'EUA', 1986),
('Activision Blizzard', 'EUA', 2008);

-- Inserindo dados na tabela Jogo
INSERT INTO Jogo (titulo, data_lancamento, preco, id_desenvolvedora) VALUES
('Half-Life', '1998-11-19', 49.99, 1),
('Fortnite', '2017-07-25', 0.00, 2),
('Cyberpunk 2077', '2020-12-10', 199.99, 3),
('GTA V', '2013-09-17', 119.99, 4),
('Assassin’s Creed Valhalla', '2020-11-10', 149.99, 5),
('Final Fantasy XV', '2016-11-29', 159.99, 6),
('The Sims 4', '2014-09-02', 99.99, 7),
('Elden Ring', '2022-02-25', 249.99, 8),
('Skyrim', '2011-11-11', 79.99, 9),
('Call of Duty: Modern Warfare', '2019-10-25', 199.99, 10);

-- Inserindo dados na tabela Categoria
INSERT INTO Categoria (nome) VALUES
('Ação'),
('Aventura'),
('RPG'),
('Simulação'),
('FPS'),
('Battle Royale'),
('Estratégia'),
('Terror'),
('Sandbox'),
('Mundo Aberto');

-- Inserindo dados na tabela JogoCategoria (Relacionamento N:N entre Jogo e Categoria)
INSERT INTO JogoCategoria (id_jogo, id_categoria) VALUES
(1, 1),
(1, 5),
(2, 6),
(3, 3),
(4, 9),
(4, 10),
(5, 2),
(6, 3),
(7, 4),
(8, 1),
(8, 3),
(9, 9),
(9, 10),
(10, 1),
(10, 5);

-- Inserindo dados na tabela Biblioteca (Relacionamento N:N entre Usuário e Jogo)
INSERT INTO Biblioteca (id_usuario, id_jogo, data_aquisicao) VALUES
(1, 1, '2023-02-10'),
(2, 2, '2023-03-01'),
(3, 3, '2023-03-21'),
(4, 4, '2023-04-23'),
(5, 5, '2023-05-31'),
(6, 6, '2023-06-06'),
(7, 7, '2023-07-08'),
(8, 8, '2023-08-12'),
(9, 9, '2023-09-15'),
(10, 10, '2023-10-19');

select * from usuario where data_cadastro > '2023-03-01';
select * from jogo where preco > 100.00;
select * from  Desenvolvedora where ano_fundacao > 2000;
select J.titulo from Jogo J join Desenvolvedora D on J.id_desenvolvedora = D.id where D.nome ='Valve Corporation';
select avg (preco) as preco_medio from jogo;
select sum(J.preco) as preco_total from Jogo J join Biblioteca B on J.id = B.id_jogo join Usuario U on B.id_usuario = U.id where U.nome = 'Carlos Silva';
select J.titulo, J.preco from Jogo J join Desenvolvedora D on J.id_desenvolvedora =D.id where D.nome = 'Rockstar Games' order by J.preco desc limit 1;
select J.titulo from Jogo J join JogoCategoria JC on J.id = JC.id_jogo join Categoria C on JC.id_categoria = C.id where C.nome ='RPG';
select U.nome as nome_usuario, J.titulo as titulo_jogo from Usuario U join Biblioteca B on U.id = B.id_usuario join Jogo J on B.id_jogo =J.id order by U.nome;
select count(J.id) as total_jogos_eua from Jogo J join Desenvolvedora D on J.id_desenvolvedora = D.id where D.pais = 'EUA';