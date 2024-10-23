select * from vendedores;

start transaction;
update vendedores set comissao = comissao * 1.15;
rollback;
commit;

start transaction;
