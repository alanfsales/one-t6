select a.cpf, a.volume_compra from clientes a inner join vendedores b
on a.bairro = b.bairro;

update clientes a inner join vendedores b
on a.bairro = b.bairro 
set a.volume_compra = a.volume_compra * 1.3;