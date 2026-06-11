create database nomeMeuSistema;

use nomeMeuSistema;

create table pessoa(
id int primary key auto_increment,
nome varchar(100) not null,
idade int,
email varchar(50)
);
select * from pessoa;
