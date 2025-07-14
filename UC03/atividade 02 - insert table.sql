use uc03;

insert into Temporada(numero)
Values ('1');

insert into Etapa (local, data, hora, id_temporada)
values
('São Paulo','2024-01-15', '14:00',1),
('Rio de Janeiro', '2024-02-20', '16:00', 1),
('Campo Grande', '2024-03-18', '15:00', 1),
('Londrina', '2024-04-22', '13:00', 1),
('Porto Alegre', '2024-05-10', '10:00', 1);

update Etapa
set local = 'Salvador'
where  id_etapa = 3;

update Etapa
set local = 'Goiânia'
where  id_etapa = 4;

insert into Patrocinador(nome)
values
('Motor Tech Brasil'),
('Velocidade Externa'),
('Alta Performance'),
('Turbo Racing'),
('Pneus ProDrive');

delete from Patrocinio
where id_patrocinio = 5;

insert into Equipe(nome, id_patrocinio)
values
('Escudeira Veloz',1),
('Rápido & Furiosos',2),
('Fênix Racing',3),
('Equipe Tempestade',4),
('Corredores de Aço',5);

set sql_safe_updates = 0;
update Equipe
set id_patrocinio = Null
where id_equipe = 10;

insert into Piloto(nome, peso, capitao, nacionalidade, id_equipe)
values
('Lucas Andrade','70.5',1, 'Brasil', 6),
('Renato Figueiredo', '75.0',0, 'Brasil', 6),
('Matheus Silva', '68.0', 0, 'Brasil',7),
('Bruno Almeida', '78.3', 1, 'Brasil',7),
('Carla Pereira', '60.0', 1, 'Portugal',8),
('Gabriela Torres', '58.5', 0, 'Brasil',8),
('João Costa', '80.5', 0, 'Brasil',9),
('Thiago Santos', '72.5', 0, 'Brasil',9),
('Mariana Gomes', '62.0', 1, 'Portugal',10),
('Beatriz Lopes', '63.2', 1, 'Portugal',10);

insert into etapa_has_piloto(etapa_id_etapa, piloto_id_piloto, id_piloto, id_etapa)
Values
(1,162,1,162),
(1,164,1,164),
(1,166,1,166),
(1,168,1,168),
(1,170,1,170),
(1,163,1,163),
(1,165,1,165),
(1,167,1,167),
(1,169,1,169),
(1,171,1,171);

