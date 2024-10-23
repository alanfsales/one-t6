select n.numero from notas n inner join clientes c
on n.cpf = c.cpf where c.idade <= 18;

delete a from notas a inner join clientes b on a.cpf = b.cpf where b.idade <=18;