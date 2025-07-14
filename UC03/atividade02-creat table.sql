use uc03;
create table Temporada(
id_temporada int auto_increment primary key,
numero int
);
create table Etapa (
id_etapa int auto_increment PRIMARY key,
local VARCHAR (100) not null UNIQUE,
data DATE,
hora varchar(45),
id_temporada int,
FOREIGN key (id_temporada) REFERENCES Temporada(id_temporada)
);
CREATE table Patrocinio (
id_patrocinio int auto_increment PRIMARY key,
nomePatrocinio VARCHAR (45) not null unique
);
CREATE TABLE Equipe (
id_equipe int auto_increment PRIMARY key,
nome VARCHAR (100) not null unique,
id_patrocinio int,
FOREIGN key (id_patrocinio)REFERENCES Patrocinio (id_patrocinio)
);
alter table Piloto
Drop index nacionalidade;

CREATE TABLE Piloto (
id_piloto int auto_increment PRIMARY key,
nome VARCHAR (150) not null unique,
peso FLOAT,
capitao tinyint,
nacionalidade VARCHAR (45) not null,
id_equipe int,
FOREIGN key (id_equipe) REFERENCES Equipe (id_equipe)
);
CREATE TABLE Etapa_has_Piloto(
etapa_id_etapa int, 
piloto_id_piloto int,
id_etapa int,
id_piloto int,
PRIMARY key (etapa_id_etapa, piloto_id_piloto),
FOREIGN key (id_etapa)REFERENCES Etapa (id_etapa),
FOREIGN key (id_piloto) REFERENCES Piloto(id_piloto)
);