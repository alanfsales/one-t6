select * from notas_fiscais;
select * from itens_notas_fiscais;

select * from notas_fiscais nf inner join itens_notas_fiscais inf on nf.NUMERO = inf.NUMERO;

select nf.CPF, nf.DATA_VENDA, inf.QUANTIDADE from notas_fiscais nf inner join itens_notas_fiscais inf on nf.NUMERO = inf.NUMERO;

/* Consulta  Quatidade compras por mes */
select nf.CPF, date_format(nf.DATA_VENDA,'%Y-%m') as Mes_Ano, sum(inf.QUANTIDADE) as Quantidade_Mes 
from notas_fiscais nf  inner join itens_notas_fiscais inf on nf.NUMERO = inf.NUMERO 
group by nf.CPF, date_format(nf.DATA_VENDA,'%Y-%m');

select * from tabela_de_clientes tc;

select tc.CEP, tc.NOME, tc.VOLUME_DE_COMPRA as Quantidade_Limite from tabela_de_clientes tc;

select nf.CPF, tc.NOME, date_format(nf.DATA_VENDA,'%Y-%m') as Mes_Ano, 
sum(inf.QUANTIDADE) as Quantidade_Mes, tc.VOLUME_DE_COMPRA as Quantidade_limite
from notas_fiscais nf  inner join itens_notas_fiscais inf on nf.NUMERO = inf.NUMERO 
inner join tabela_de_clientes tc on tc.CPF = nf.CPF
group by nf.CPF, tc.NOME, date_format(nf.DATA_VENDA,'%Y-%m');

select x.cpf, x.nome, x.Mes_Ano, x.Quantidade_Mes, x.Quantidade_Limite,
x.Quantidade_limite - x.Quantidade_Mes as Diferenca,
case when x.Quantidade_limite - x.Quantidade_Mes < 0 then 'Invalida'
else 'Valida' end as Status_venda
from (select nf.CPF, tc.NOME, date_format(nf.DATA_VENDA,'%Y-%m') as Mes_Ano, 
sum(inf.QUANTIDADE) as Quantidade_Mes, tc.VOLUME_DE_COMPRA as Quantidade_limite
from notas_fiscais nf  inner join itens_notas_fiscais inf on nf.NUMERO = inf.NUMERO 
inner join tabela_de_clientes tc on tc.CPF = nf.CPF
group by nf.CPF, tc.NOME, date_format(nf.DATA_VENDA,'%Y-%m')) x;

select x.cpf, x.nome, x.Mes_Ano, x.Quantidade_Mes, x.Quantidade_Limite,
case when x.Quantidade_limite - x.Quantidade_Mes < 0 then 'Invalida'
else 'Valida' end as Status_venda, round((1 - (X.Quantidade_Limite/X.Quantidade_Mes)) * 100, 1) AS PERCENTUAL
from (select nf.CPF, tc.NOME, date_format(nf.DATA_VENDA,'%Y-%m') as Mes_Ano, 
sum(inf.QUANTIDADE) as Quantidade_Mes, tc.VOLUME_DE_COMPRA as Quantidade_limite
from notas_fiscais nf  inner join itens_notas_fiscais inf on nf.NUMERO = inf.NUMERO 
inner join tabela_de_clientes tc on tc.CPF = nf.CPF
group by nf.CPF, tc.NOME, date_format(nf.DATA_VENDA,'%Y-%m')) x 
where x.Quantidade_limite - x.Quantidade_Mes < 0;