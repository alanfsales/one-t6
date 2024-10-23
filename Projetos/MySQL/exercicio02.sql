select tp.SABOR, nf.DATA_VENDA, inf.QUANTIDADE from tabela_de_produtos tp 
inner join itens_notas_fiscais inf on tp.CODIGO_DO_PRODUTO = inf.CODIGO_DO_PRODUTO
inner join notas_fiscais nf on nf.NUMERO = inf.NUMERO;

select tp.SABOR, year(nf.DATA_VENDA) as Ano, sum(inf.QUANTIDADE) as Quatidade 
from tabela_de_produtos tp 
inner join itens_notas_fiscais inf on tp.CODIGO_DO_PRODUTO = inf.CODIGO_DO_PRODUTO
inner join notas_fiscais nf on nf.NUMERO = inf.NUMERO
group by tp.SABOR, year(nf.DATA_VENDA);

select tp.SABOR, year(nf.DATA_VENDA) as Ano, sum(inf.QUANTIDADE) as Quatidade 
from tabela_de_produtos tp 
inner join itens_notas_fiscais inf on tp.CODIGO_DO_PRODUTO = inf.CODIGO_DO_PRODUTO
inner join notas_fiscais nf on nf.NUMERO = inf.NUMERO
where year(nf.DATA_VENDA) = 2016
group by tp.SABOR, year(nf.DATA_VENDA)
order by sum(inf.QUANTIDADE) desc;

select year(nf.DATA_VENDA) as Ano, sum(inf.QUANTIDADE) as Quatidade 
from tabela_de_produtos tp 
inner join itens_notas_fiscais inf on tp.CODIGO_DO_PRODUTO = inf.CODIGO_DO_PRODUTO
inner join notas_fiscais nf on nf.NUMERO = inf.NUMERO
where year(nf.DATA_VENDA) = 2016
group by year(nf.DATA_VENDA);

/*---------------*/
select * from
(select tp.SABOR, year(nf.DATA_VENDA) as Ano, sum(inf.QUANTIDADE) as Quatidade 
from tabela_de_produtos tp 
inner join itens_notas_fiscais inf on tp.CODIGO_DO_PRODUTO = inf.CODIGO_DO_PRODUTO
inner join notas_fiscais nf on nf.NUMERO = inf.NUMERO
where year(nf.DATA_VENDA) = 2016
group by tp.SABOR, year(nf.DATA_VENDA)) as venda_sabor
inner join
(select year(nf.DATA_VENDA) as Ano, sum(inf.QUANTIDADE) as Quatidade 
from tabela_de_produtos tp 
inner join itens_notas_fiscais inf on tp.CODIGO_DO_PRODUTO = inf.CODIGO_DO_PRODUTO
inner join notas_fiscais nf on nf.NUMERO = inf.NUMERO
where year(nf.DATA_VENDA) = 2016
group by year(nf.DATA_VENDA)) as venda_total
on venda_sabor.Ano = venda_total.Ano;

/*---------------*/
select venda_sabor.SABOR, venda_sabor.Ano, venda_sabor.Quantidade,
round((venda_sabor.QUANTIDADE / venda_total.Quatidade) * 100, 2) as Participacao from
(select tp.SABOR, year(nf.DATA_VENDA) as Ano, sum(inf.QUANTIDADE) as Quantidade 
from tabela_de_produtos tp 
inner join itens_notas_fiscais inf on tp.CODIGO_DO_PRODUTO = inf.CODIGO_DO_PRODUTO
inner join notas_fiscais nf on nf.NUMERO = inf.NUMERO
where year(nf.DATA_VENDA) = 2016
group by tp.SABOR, year(nf.DATA_VENDA)) as venda_sabor
inner join
(select year(nf.DATA_VENDA) as Ano, sum(inf.QUANTIDADE) as Quatidade 
from tabela_de_produtos tp 
inner join itens_notas_fiscais inf on tp.CODIGO_DO_PRODUTO = inf.CODIGO_DO_PRODUTO
inner join notas_fiscais nf on nf.NUMERO = inf.NUMERO
where year(nf.DATA_VENDA) = 2016
group by year(nf.DATA_VENDA)) as venda_total
on venda_sabor.Ano = venda_total.Ano
order by venda_sabor.Quantidade desc;
