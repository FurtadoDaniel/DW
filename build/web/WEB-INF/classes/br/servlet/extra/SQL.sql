CREATE TABLE CATEGORIA (ID int not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
                      DESCRICAO varchar(100));

CREATE TABLE PRODUTO (ID int not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
                      VALOR float, 
                      CATEGORIA int,
                      NOME varchar(30),
                      DESCRICAO varchar(100));



CREATE TABLE CLIENTES (ID int not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
                      NOME varchar(50),
                      ENDERECO varchar(50),
                      BAIRRO varchar(30),
                      CEP varchar(8),
                      ESTADO varchar(2),
                      REFERENCIA varchar(50),
                      CPF varchar(11),
                      RG varchar(15),
                      TELEFONE varchar(10),
                      CELULAR varchar(11),
                      CARTAO varchar(28),
                      BANDEIRA varchar(30));

CREATE TABLE COMPRAS (ID int not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
                      CLIENTE int , 
                      PRODUTO int);

CREATE TABLE ADMINISTRADOR (ID int not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
                      USUARIO float, 
                      SENHA int);