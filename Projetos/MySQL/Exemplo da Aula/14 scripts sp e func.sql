call exibe_variavel;

Call inclui_novo_produto_parametro_2('4000056', 'Sabor do Pantanal 1 Litro - Melancia',
'Melancia', '1 Litro', 'PET', 4.76);

Call acha_sabor_produto('1013793');

Call cliente_novo_velho ('19290992743');

Call acha_status_preco_2 ('1000889');

CALL acha_tipo_sabor('1000889');

CALL acha_tipo_sabor_erro('1004327');

call looping_while (1, 100);

call cursor_looping;

call looping_cursor_multiplas_colunas;

SET GLOBAL log_bin_trust_function_creators = 1;

SELECT f_acha_tipo_sabor ("Laranja");

SELECT NOME_DO_PRODUTO, SABOR, f_acha_tipo_sabor (SABOR) as TIPO FROM tabela_de_produtos;

SELECT f_cliente_aleatorio(), f_produto_aleatorio(), f_vendedor_aleatorio();

Call p_inserir_venda('20240904', 3, 100);

select nf.numero, inf.CODIGO_DO_PRODUTO from notas_fiscais nf inner join itens_notas_fiscais inf 
on nf.NUMERO = inf.NUMERO where DATA_VENDA = '20240904';

select * from itens_notas_fiscais where NUMERO = '87984';
select * from notas_fiscais where DATA_VENDA = '20240904';