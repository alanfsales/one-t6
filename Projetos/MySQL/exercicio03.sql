select venda_tamanho.TAMANHO, venda_tamanho.Ano, venda_tamanho.Quantidade,
round((venda_tamanho.QUANTIDADE / venda_total.Quatidade) * 100, 2) as Participacao from
(select tp.TAMANHO, year(nf.DATA_VENDA) as Ano, sum(inf.QUANTIDADE) as Quantidade 
from tabela_de_produtos tp 
inner join itens_notas_fiscais inf on tp.CODIGO_DO_PRODUTO = inf.CODIGO_DO_PRODUTO
inner join notas_fiscais nf on nf.NUMERO = inf.NUMERO
where year(nf.DATA_VENDA) = 2016
group by tp.TAMANHO, year(nf.DATA_VENDA)) as venda_tamanho
inner join
(select year(nf.DATA_VENDA) as Ano, sum(inf.QUANTIDADE) as Quatidade 
from tabela_de_produtos tp 
inner join itens_notas_fiscais inf on tp.CODIGO_DO_PRODUTO = inf.CODIGO_DO_PRODUTO
inner join notas_fiscais nf on nf.NUMERO = inf.NUMERO
where year(nf.DATA_VENDA) = 2016
group by year(nf.DATA_VENDA)) as venda_total
on venda_tamanho.Ano = venda_total.Ano
order by venda_tamanho.Quantidade desc;