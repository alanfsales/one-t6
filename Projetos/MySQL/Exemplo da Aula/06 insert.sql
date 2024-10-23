select * from sucos_vendas.tabela_de_produtos;

insert into produtos
select codigo_do_produto as produto, nome_do_produto as descritor, 
sabor, tamanho, embalagem, preco_de_lista as preco_lista 
from sucos_vendas.tabela_de_produtos
where codigo_do_produto not in (select codigo from produtos);

select * from produtos;

/*-------------------------*/

select * from sucos_vendas.tabela_de_clientes;

insert into clientes
select cpf, nome, endereco_1 as endereco, bairro, cidade, estado, cep, 
data_de_nascimento as data_nascimento, idade, sexo, limite_de_credito as limite_credito,
volume_de_compra as volume_compra, primeira_compra
from sucos_vendas.tabela_de_clientes
where cpf not in (select cpf from clientes);

select * from clientes;