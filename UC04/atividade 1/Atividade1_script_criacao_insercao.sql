-- Criação do banco de dados
CREATE DATABASE IF NOT EXISTS InvestimentosDB;
USE InvestimentosDB;

-- Tabela de clientes
CREATE TABLE Clientes (
    cliente_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    email VARCHAR(100),
    telefone VARCHAR(15),
    endereco VARCHAR(255),
    data_cadastro DATETIME
);

-- Tabela de contas de investimento
CREATE TABLE ContasInvestimento (
    conta_id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT,
    saldo DECIMAL(15, 2) DEFAULT 0.00,
    tipo_conta ENUM('Poupança', 'Fundo de Investimento', 'Ações') NOT NULL,
    data_abertura DATETIME,
    FOREIGN KEY (cliente_id) REFERENCES Clientes(cliente_id)
);

-- Tabela de transações de investimento
CREATE TABLE Transacoes (
    transacao_id INT AUTO_INCREMENT PRIMARY KEY,
    conta_id INT,
    tipo_transacao ENUM('Depósito', 'Retirada', 'Aplicação', 'Resgate') NOT NULL,
    valor DECIMAL(15, 2) NOT NULL,
    data_transacao DATETIME,
    descricao VARCHAR(255),
    FOREIGN KEY (conta_id) REFERENCES ContasInvestimento(conta_id)
);

-- Inserção de dados na tabela de clientes
INSERT INTO Clientes (nome, cpf, email, telefone, endereco, data_cadastro) VALUES
('João Almeida', '12345678901', 'joao.almeida@email.com', '11987654321', 'Rua Central, 100, São Paulo', '2023-10-01 10:30:00'),
('Maria Santos', '98765432100', 'maria.santos@email.com', '21976543210', 'Avenida Paulista, 500, São Paulo', '2023-10-02 15:45:00'),
('Carlos Souza', '12312312399', 'carlos.souza@email.com', '31954321098', 'Avenida da Liberdade, 450, Belo Horizonte', '2023-10-03 09:00:00');

-- Inserção de dados na tabela de contas de investimento
INSERT INTO ContasInvestimento (cliente_id, saldo, tipo_conta, data_abertura) VALUES
(1, 5000.00, 'Poupança', '2023-10-05 10:00:00'),
(2, 12000.00, 'Fundo de Investimento', '2023-10-06 14:20:00'),
(3, 7500.00, 'Ações', '2023-10-07 16:30:00');

-- Inserção de dados na tabela de transações de investimento
INSERT INTO Transacoes (conta_id, tipo_transacao, valor, data_transacao, descricao) VALUES
(1, 'Depósito', 1000.00, '2023-10-08 11:00:00', 'Depósito inicial na poupança'),
(2, 'Aplicação', 2000.00, '2023-10-09 13:30:00', 'Aplicação em fundo de renda fixa'),
(3, 'Retirada', 500.00, '2023-10-10 09:45:00', 'Retirada para despesas pessoais'),
(1, 'Aplicação', 1500.00, '2023-10-11 17:00:00', 'Aplicação em ações via poupança'),
(2, 'Resgate', 3000.00, '2023-10-12 15:30:00', 'Resgate parcial do fundo de investimento');

-- Criação de usúarios adm
create user 'jose'@'localhost' identified by '123@senha';
grant select, insert on investmentosdb.* to 'jose'@'localhost';

create user 'Lucas'@'localhost' identified by '123@senha';
grant select on investmentosdb.* to 'Lucas'@'localhost';

create user 'Marlene'@'localhost' identified by '123@senha';
grant all privileges on investmentosdb.* to 'Marlene'@'localhost';
