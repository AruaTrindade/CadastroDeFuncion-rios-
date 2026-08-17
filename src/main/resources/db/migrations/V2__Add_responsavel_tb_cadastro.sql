--Migrations para adicionar a coluna de RANK na tabela de cadastro

ALTER TABLE tb_cadastro
ADD COLUMN responsavel VARCHAR(255);