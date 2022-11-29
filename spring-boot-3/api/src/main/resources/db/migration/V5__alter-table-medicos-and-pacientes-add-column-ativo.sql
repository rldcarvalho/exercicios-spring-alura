ALTER TABLE medicos ADD ativo tinyint;
UPDATE medicos set ativo = 1;

ALTER TABLE pacientes ADD ativo tinyint;
UPDATE pacientes set ativo = 1;
