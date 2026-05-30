CREATE DATABASE IF NOT EXISTS mercado_inteligente;
USE mercado_inteligente;
 
CREATE TABLE cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    endereco VARCHAR(255)
);
 
CREATE TABLE produto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigo_barras VARCHAR(20) UNIQUE NOT NULL,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    quantidade_estoque INT NOT NULL DEFAULT 0
);
 
CREATE TABLE pedido (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cliente_id BIGINT NOT NULL,
    data_pedido DATETIME DEFAULT CURRENT_TIMESTAMP,
    valor_total DECIMAL(10,2) NOT NULL,
    status VARCHAR(20) DEFAULT 'PENDENTE',
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);
 
CREATE TABLE item_pedido (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pedido_id BIGINT NOT NULL,
    produto_id BIGINT NOT NULL,
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES pedido(id),
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);
 
CREATE TABLE delivery (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pedido_id BIGINT NOT NULL,
    endereco_entrega VARCHAR(255) NOT NULL,
    data_solicitacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    data_entrega_prevista DATETIME,
    status_entrega VARCHAR(30) DEFAULT 'PENDENTE',
    taxa_entrega DECIMAL(10,2) DEFAULT 8.90,
    FOREIGN KEY (pedido_id) REFERENCES pedido(id)
);
select * FROM produto;
select * from delivery;


DROP TABLE IF EXISTS delivery;
 
CREATE TABLE delivery (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    endereco_entrega VARCHAR(255) NOT NULL,
    taxa_entrega DECIMAL(10,2) NOT NULL DEFAULT 8.90,
    status_entrega VARCHAR(30) DEFAULT 'PENDENTE',
    data_solicitacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    data_entrega_prevista DATETIME DEFAULT (CURRENT_TIMESTAMP + INTERVAL 2 DAY)
);


 