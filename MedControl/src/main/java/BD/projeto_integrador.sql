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












