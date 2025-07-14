create table Endereco(
endereco_id int auto_increment primary key,
rua varchar(255) not null,
numero varchar(10),
cidade varchar (100) not null,
estado varchar(50) not null,
cep varchar (10) not null
);
create table Usuario(
usuario_id int auto_increment primary key,
nome varchar(100) not null,
email varchar(100)unique not null,
cpf varchar(11)unique not null,
endereco_id int unique not null,
foreign key (endereco_id) references Endereco(endereco_id)
);
create table Estudio(
estudio_id int auto_increment primary key,
nome varchar(100) not null unique
);
create table Conteudo(
conteudo_id int auto_increment primary key,
titulo varchar(255) not null,
genero varchar(50),
ano int,
estudio_id int not null,
foreign key (estudio_id) references Estudio(estudio_id)
);
create table Visualizacao(
visualizacao_id int auto_increment primary key,
usuario_id int not null,
conteudo_id int not null,
tempo_visualizacao_minutos int,
foreign key (usuario_id) references Usuario(usuario_id),
foreign key (conteudo_id) references Conteudo(conteudo_id)
);