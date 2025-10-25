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

create table lista_medicamento(
codigo int primary key auto_increment,
custo_unit double not null,
valor_unit double not null,
descricao varchar(50) not null
);

create table compra( 
num_nf_entrada int primary key,
data_entrada varchar(10) not null,
valor_total double not null,
custo_total double not null,
total_nota double not null,
forma_pagamento varchar(10),
data_ult_compra date not null
);

create table item_compra(
codigo int primary key auto_increment,
custo_unit double not null,
valor_unit double not null,
descricao varchar(50) not null
);

create table medicamento(
codigo int primary key auto_increment,
custo_unit double not null,
valor_unit double not null,
descricao varchar(50) not null
);

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

create table item_venda(
codigo int primary key auto_increment,
custo_unit double not null,
valor_unit double not null,
descricao varchar(50) not null
);

create table venda(
nmr_nf_entrada int primary key,
data_entrega date not null,
valor_total double not null,
custo_total double not null,
qtde int not null,
total_nota double not null,
forma_pagamento varchar(10) not null,
data_ult_compra date not null
);

create table fornece_medicamento(
cnpj varchar(30),
codigo int auto_increment,
foreign key (cnpj) references laboratorio_fornecedor(cnpj),
foreign key (codigo) references lista_medicamento(codigo)
);

create table fornecedor_compra(
cnpj varchar(30),
num_nf_entrada int,
foreign key (cnpj) references laboratorio_fornecedor(cnpj),
foreign key (num_nf_entrada) references compra(num_nf_entrada)
);

create table compra_itemcompra(
num_nf_entrada int,
codigo int auto_increment,
foreign key (num_nf_entrada) references compra(num_nf_entrada),
foreign key (codigo) references item_compra(codigo)
);

create table compra_medicamento(
num_nf_entrada int,
codigo int auto_increment,
foreign key (num_nf_entrada) references compra(num_nf_entrada),
foreign key (codigo) references medicamento(codigo)
);

create table venda_medicamento(
nmr_nf_entrada int,
codigo int auto_increment,
foreign key (nmr_nf_entrada) references venda(nmr_nf_entrada),
foreign key (codigo) references medicamento(codigo)
);

create table venda_drogaria(
nmr_nf_entrada int,
cnpj varchar(30),
foreign key (nmr_nf_entrada) references venda(nmr_nf_entrada),
foreign key (cnpj) references drogaria(cnpj)
);

create table venda_itemvenda(
nmr_nf_entrada int,
codigo int auto_increment,
foreign key (nmr_nf_entrada) references venda(nmr_nf_entrada),
foreign key (codigo) references item_venda(codigo)
);










