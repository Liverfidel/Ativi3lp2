create database hotel1;
use hotel1;

create table hotelaria(
  idhotel integer not null auto_increment,
  nome varchar(50) not null, 
  endereco varchar(50) not null,
  cep int not null,
  primary key(idhotel)
);

select * from hotelaria;
