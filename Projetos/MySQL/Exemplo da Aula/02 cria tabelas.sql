create table produtos(
codigo varchar(10) not null,
descritor varchar(100) null,
sabor varchar(50) null,
tamanho varchar(50) null,
embalagem varchar(50) null,
preco_lista float null,

primary key(codigo));

create table vendedores(
matricula varchar(5) not null,
nome varchar(100) null,
bairro varchar(50) null,
comissao float null,
data_adimissao date null,
ferias bit(1) null,

primary key(matricula));

alter table vendedores rename column data_adimissao to data_admissao;

create table clientes(
cpf varchar(11) not null,
nome varchar(100) null,
endereco varchar(150) null,
bairro varchar(50) null,
cidade varchar(50) null,
estado varchar(50) null,
cep varchar(8) null,
data_nascimento date null,
idade int null,
sexo varchar(1) null,
limite_credito float null,
volume_compra float null,
primeira_compra bit(1) null,

primary key(cpf));

