-- Migrations para apagar a tabela tb_cadastro

DROP TABLE IF EXISTS tb_cadastro;

--Migrations para adicionar a coluna de RANK na tabela de cadastro

ALTER TABLE tb_departamento
    ADD COLUMN responsavel VARCHAR(255);