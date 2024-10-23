select * from vendedores;
select * from sucos_vendas.tabela_de_vendedores;

select * from vendedores a inner join sucos_vendas.tabela_de_vendedores b
on a.matricula = substring(b.matricula,3,3);

update vendedores a inner join sucos_vendas.tabela_de_vendedores b
on a.matricula = substring(b.matricula,3,3)
set a.ferias = b.de_ferias;