create database projeto_integrador;
use projeto_integrador;

create table laboratorio_fornecedor(
cnpj varchar(30) primary key,
IE varchar(30),
nome varchar(30) not null,
cep varchar(30) not null,
estado varchar(30) not null,
cidade varchar(30) not null,
bairro varchar(30) not null,
rua varchar(30) not null,
numero varchar(5) not null
);

select * from laboratorio_fornecedor;

create table lista_medicamento(
codigo int primary key auto_increment,
cnpj_lab varchar(30),
custo_unit double not null,
valor_unit double not null,
descricao varchar(50) not null,
foreign key (cnpj_lab) references laboratorio_fornecedor (cnpj)
);

select * from lista_medicamento;

create table compra( 
num_nf_entrada int primary key,
cnpj_lab varchar(30),
data_entrada varchar(10) not null,
valor_total double not null,
custo_total double not null,
total_nota double not null,
forma_pagamento varchar(10),
data_ult_compra date not null,
foreign key (cnpj_lab) references laboratorio_fornecedor (cnpj)
);

select * from compra;

create table item_compra(
codigo int primary key auto_increment,
num_nf_entrada_compra int,
custo_unit double not null,
valor_unit double not null,
descricao varchar(50) not null,
foreign key (num_nf_entrada_compra) references compra (num_nf_entrada)
);

select * from item_compra;

create table medicamento(
codigo int primary key auto_increment,
num_nf_entrada_compra int,
num_nf_entrada_venda int,
custo_unit double not null,
valor_unit double not null,
descricao varchar(50) not null,
foreign key (num_nf_entrada_compra) references compra (num_nf_entrada),	
foreign key (num_nf_entrada_venda) references venda (nmr_nf_entrada)
);

select * from medicamento;

create table drogaria(
cnpj varchar(30) primary key,
nome varchar(30) not null,
cep varchar(30) not null,
estado varchar(30) not null,
cidade varchar(30) not null,
bairro varchar(30) not null,
rua varchar(30) not null,
numero varchar(5) not null
);

select * from drogaria;

create table item_venda(
codigo int primary key auto_increment,
num_nf_entrada_venda int,
custo_unit double not null,
valor_unit double not null,
descricao varchar(50) not null,
foreign key (num_nf_entrada_venda) references venda (nmr_nf_entrada)
);

select * from item_venda;

create table venda(
nmr_nf_entrada int primary key,
cnpj_drogaria varchar(30),
data_entrega date not null,
valor_total double not null,
custo_total double not null,
qtde int not null,
total_nota double not null,
forma_pagamento varchar(10) not null,
data_ult_compra date not null,
foreign key (cnpj_drogaria) references drogaria (cnpj)
);

select * from venda;

-- Índices de pesquisa
CREATE INDEX idx_lab_nome ON laboratorio_fornecedor(nome);
CREATE INDEX idx_lab_cidade ON laboratorio_fornecedor(cidade);
 
CREATE INDEX idx_medicamento_descricao ON lista_medicamento(descricao);
CREATE INDEX idx_compra_cnpj ON compra(cnpj_lab);
CREATE INDEX idx_venda_cnpj ON venda(cnpj_drogaria);
 
CREATE INDEX idx_item_compra_nf ON item_compra(num_nf_entrada_compra);
CREATE INDEX idx_item_venda_nf ON item_venda(num_nf_entrada_venda);
 
-- CREATE Insere Laboratório
DELIMITER //
 
CREATE PROCEDURE inserir_laboratorio(
    IN p_cnpj VARCHAR(30),
    IN p_IE VARCHAR(30),
    IN p_nome VARCHAR(30),
    IN p_cep VARCHAR(30),
    IN p_estado VARCHAR(30),
    IN p_cidade VARCHAR(30),
    IN p_bairro VARCHAR(30),
    IN p_rua VARCHAR(30),
    IN p_numero VARCHAR(5)
)
BEGIN
    INSERT INTO laboratorio_fornecedor (cnpj, IE, nome, cep, estado, cidade, bairro, rua, numero)
    VALUES (p_cnpj, p_IE, p_nome, p_cep, p_estado, p_cidade, p_bairro, p_rua, p_numero);
END //
 
DELIMITER ;
 
-- READ – Consultar laboratórios
DELIMITER //
 
CREATE PROCEDURE listar_laboratorios()
BEGIN
    SELECT * FROM laboratorio_fornecedor;
END //
 
DELIMITER ;
 
-- UPDATE – Atualizar laboratório
DELIMITER //
 
CREATE PROCEDURE atualizar_laboratorio(
    IN p_cnpj VARCHAR(30),
    IN p_nome VARCHAR(30),
    IN p_cidade VARCHAR(30),
    IN p_estado VARCHAR(30)
)
BEGIN
    UPDATE laboratorio_fornecedor
    SET nome = p_nome,
        cidade = p_cidade,
        estado = p_estado
    WHERE cnpj = p_cnpj;
END //
 
DELIMITER ;
 
-- DELETE – Excluir laboratório
DELIMITER //
 
CREATE PROCEDURE deletar_laboratorio(IN p_cnpj VARCHAR(30))
BEGIN
    DELETE FROM laboratorio_fornecedor WHERE cnpj = p_cnpj;
END //
 
DELIMITER ;
 
-- TRIGGERS
-- Trigger 1: Atualizar valor_total e custo_total automaticamente na tabela compra
-- Quando um item é inserido em item_compra, o total da compra deve ser recalculado.
DELIMITER //
 
CREATE TRIGGER atualiza_totais_compra
AFTER INSERT ON item_compra
FOR EACH ROW
BEGIN
    UPDATE compra
    SET valor_total = valor_total + NEW.valor_unit,
        custo_total = custo_total + NEW.custo_unit,
        total_nota = valor_total + custo_total
    WHERE num_nf_entrada = NEW.num_nf_entrada_compra;
END //
 
DELIMITER ;
 
-- Trigger 2: Atualizar valor_total e custo_total automaticamente na tabela venda
-- Mesmo conceito, mas para vendas:
DELIMITER //
 
CREATE TRIGGER atualiza_totais_venda
AFTER INSERT ON item_venda
FOR EACH ROW
BEGIN
    UPDATE venda
    SET valor_total = valor_total + NEW.valor_unit,
        custo_total = custo_total + NEW.custo_unit,
        total_nota = valor_total + custo_total
    WHERE nmr_nf_entrada = NEW.num_nf_entrada_venda;
END //
 
DELIMITER ;
 
-- Trigger 3: Log de ações (auditoria)
-- Cria uma tabela para guardar o que foi alterado.
CREATE TABLE log_auditoria (
    id INT AUTO_INCREMENT PRIMARY KEY,
    acao VARCHAR(50),
    tabela_afetada VARCHAR(50),
    data_hora DATETIME,
    usuario VARCHAR(50)
);
 
-- Trigger de exemplo para registrar deleção de laboratório:
DELIMITER //
 
CREATE TRIGGER log_delete_laboratorio
AFTER DELETE ON laboratorio_fornecedor
FOR EACH ROW
BEGIN
    INSERT INTO log_auditoria (acao, tabela_afetada, data_hora, usuario)
    VALUES ('DELETE', 'laboratorio_fornecedor', NOW(), CURRENT_USER());
END //
 
DELIMITER ;
 
-- Teste
CALL inserir_laboratorio('12345678000199', 'IE001', 'Lab Saúde', '12345-000', 'SP', 'São Paulo', 'Centro', 'Rua A', '100');
 
CALL listar_laboratorios();
 
CALL atualizar_laboratorio('12345678000199', 'Lab Vida Nova', 'Campinas', 'SP');
 
CALL deletar_laboratorio('12345678000199');











