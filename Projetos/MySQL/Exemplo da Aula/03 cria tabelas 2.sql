create table notas(
numero varchar(5) not null,
data_venda date null,
cpf varchar(11) not null,
matricula varchar(5) not null,
imposto float null,

primary key(numero));

alter table tabela_de_vendas add constraint fk_clientes foreign key(cpf) references clientes (cpf);

alter table tabela_de_vendas add constraint fk_vendedores foreign key(matricula) references vendedores (matricula);

alter table tabela_de_vendas rename notas;