select a.nome_do_produto, year(b.DATA_VENDA) as ano, sum(c.quantidade) as quantidade 
from tabela_de_produtos a 
inner join itens_notas_fiscais c on a.CODIGO_DO_PRODUTO = c.CODIGO_DO_PRODUTO 
inner join notas_fiscais b on c.NUMERO = b.NUMERO
group by a.nome_do_produto, year(b.DATA_VENDA) 
order by a.nome_do_produto, year(b.DATA_VENDA);