!--Adicionando a coluna ativo

alter table medico add ativo tinyint;
update medico set ativo =1;