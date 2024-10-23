select * from produtos;

insert into produtos(codigo, descritor, sabor, tamanho, embalagem, preco_lista)
values ('1040107', 'Light - 350 ml - Melância', 'Melância', '350 ml', 'Lata', 4.56);

insert into produtos(codigo, descritor, sabor, tamanho, embalagem, preco_lista)
values ('1040108', 'Light - 350 ml - Graviola', 'Graviola', '350 ml', 'Lata', 4.00);

insert into produtos(codigo, descritor, sabor, tamanho, embalagem, preco_lista)
values ('1040109', 'Light - 350 ml - Açai', 'Açai', '350 ml', 'Lata', 5.60);

insert into produtos(codigo, descritor, sabor, tamanho, embalagem, preco_lista)
values ('1040110', 'Light - 350 ml - Jaca', 'Jaca', '350 ml', 'Lata', 6),
	   ('1040111', 'Light - 350 ml - Manga', 'Manga', '350 ml', 'Lata', 3.5);
       
/*--------------------------*/

select * from clientes;
       
insert into clientes (cpf, nome, endereco, bairro, cidade, estado, cep, data_nascimento, 
	idade, sexo, limite_credito, volume_compra, primeira_compra)
values ('1471156710','Érica Carvalho', 'R. Iriquitia', 'Jardins', 'São Paulo', 'SP', 
	'80012212', '1990-09-01', 27, 'F', 170000, 24500, 0),
    ('19290992743','Fernando Cavalcante', 'R. Dois de Fevereiro', 'Água Santa', 'Rio de Janeiro', 'RJ', 
	'22000000', '2000-02-12', 18, 'M', 100000, 20000, 1),
    ('2600586709','César Teixeira', 'Rua Conde de Bonfim', 'Tijuca', 'Rio de Janeiro', 'RJ', 
	'22020001', '2000-03-12', 18, 'M', 120000, 22000, 0);
    




