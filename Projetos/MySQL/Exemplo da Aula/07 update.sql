select * from produtos where codigo = '1000889';

update produtos set preco_lista = 5 where codigo = '1000889';

update produtos set embalagem = 'PET', tamanho = '1 Litro', 
descritor = 'Sabor da Montanha - 1 Litro - Uva' where codigo = '1000889';

select * from produtos where sabor = 'Maracujá';

update produtos set preco_lista = preco_lista * 1.10 where sabor = 'Maracujá';

select * from clientes where cpf = '19290992743 ';

update clientes set endereco = 'R. Jorge Emílio 23', bairro = 'Santo Amaro', 
cidade = 'São Paulo', estado = 'SP' ,cep = '8833223' where cpf = '19290992743 ';